package com.rccl.cp.ive.update.readside.po;

import static akka.pattern.PatternsCS.ask;
import static akka.pattern.PatternsCS.gracefulStop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
// import com.datastax.driver.core.ResultSetFuture;
import com.lightbend.lagom.javadsl.api.deser.ExceptionMessage;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.TransportErrorCode;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;

import akka.Done;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.duration.Duration;

public class ReadsideGuestCalendarEventPersistorDefaultImpl
    implements ReadsideGuestCalendarPersistor {

    private Logger logger = LoggerFactory.getLogger(
        ReadsideGuestCalendarEventPersistorDefaultImpl.class);
    private ActorRef actor;
    private static final int YOU_ARE_TOO_POPULAR_COUNT = 16;
    private static final int TIMEOUT = 3;
    private static final long ASK_TIMEOUT_MS = 6000;
    private static final long ONE_MILLISECOND = 1000;

    @Inject
    public ReadsideGuestCalendarEventPersistorDefaultImpl(
        final ActorSystem actorSystem,
        final CassandraSession cassandraSession) {
        // logger.debug("Actor system injected:" + actorSystem);
        this.actor = actorSystem.actorOf(Props.create(
            AttendeeWorkerActor.class, cassandraSession));
    }

    public final CompletionStage<Done> prepareUpdateEvent(
        final CassandraSession session) {
        logger.debug("prepareUpdateEvent");
        return prepareWriteEvent(session).thenCompose(a -> prepareWriteAttendee(session));
    }

    private CompletionStage<Done> prepareWriteEvent(
        final CassandraSession session) {
        // to do: Check data structure availability
        return new CompletableFuture<Done>();
    }

    private CompletionStage<Done> prepareWriteAttendee(
        final CassandraSession session) {
        // to do: Check data structure availability
        return new CompletableFuture<Done>();

    }

    @Override
    public final void processUpdateEvent(
        final CassandraSession cassandraSession,
        final BasicMessage message) {
        Profiler stopWatch = new Profiler("processUpdateEvent");
        stopWatch.setLogger(logger);
        // if (logger.isDebugEnabled()) {
        // logger.debug("processUpdateEvent " + message);
        // }
        if (actor == null) {
            logger.error("ACTOR is NULL");
        }
        if (actor != null && message.attendees().isPresent()) {
            List<EventAttendee> attendees = message.attendees().get();
            if (attendees != null) {
                final int totalCount = attendees.size();
                for (int fromIndex = 0; fromIndex < totalCount;
                    fromIndex += YOU_ARE_TOO_POPULAR_COUNT) {
                    int toIndex = Math.min(totalCount,
                        fromIndex + YOU_ARE_TOO_POPULAR_COUNT);
                    if (logger.isDebugEnabled()) {
                        logger.debug("processUpdateEvent from " + fromIndex
                            + " to " + toIndex);
                    }
                    List<EventAttendee> sublistAttendees =
                        attendees.subList(fromIndex, toIndex);
                    AttendeeUpdateMessage messageForActor =
                        new AttendeeUpdateMessage(message, sublistAttendees);
                    CompletableFuture<Object> future =
                        ask(actor, messageForActor, ASK_TIMEOUT_MS).toCompletableFuture();
                    future.whenComplete((value, exception) -> {
                        if (exception != null) {
                            logger.error(exception.toString());
                        }
                    });
                }
            }
        }
        stopWatch.stop();
        if (logger.isDebugEnabled()) {
            stopWatch.log();
        }
    }

    @Override
    public final void processRemoveEvent(
        final CassandraSession cassandraSession,
        final String shipSailDate,
        final String ownerReservationID,
        final String ownerGuestID,
        final String sourceSystemApplicationID,
        final String sourceSystemOfferingID,
        final String guestID,
        final String eventType) {
        logger.debug("deleting {}/{}/{}/{}/{}", shipSailDate, guestID,
            ownerGuestID, sourceSystemApplicationID, sourceSystemOfferingID);
        Profiler stopWatch = new Profiler("processRemoveEvent");
        stopWatch.setLogger(logger);
        com.datastax.driver.core.Session session;
        try {
            session = cassandraSession.underlying().toCompletableFuture()
                .get(TIMEOUT, TimeUnit.SECONDS);

            List<String> guestsToRemove = new ArrayList<String>();
            if (guestID.equals(ownerGuestID) && (eventType.equals("SELF") || eventType.equals("CRUISECOMPASS"))) {
                guestsToRemove = getAttendeeGuestIDs(cassandraSession,
                    shipSailDate, ownerReservationID, guestID,
                    sourceSystemApplicationID, sourceSystemOfferingID);
            } else {
                guestsToRemove.add(guestID);
            }
            logger.debug("Guests: " + guestsToRemove);
            PreparedStatement cancelQueryEvent = session.prepare(
                "DELETE FROM guest_calendar.calendar_events_by_guest "
                    + "where sailing_id = ? and "
                    + "guest_id = ? and "
                    + "source_system_reservation_id = ? and "
                    + "source_system_application_id = ? and "
                    + "source_system_offering_id = ?");

            PreparedStatement cancelQueryAttendee;
            if (guestsToRemove.size() > 1) {
                // Deleting by owner for self event, so remove all attendees
                cancelQueryAttendee = session.prepare(
                    "DELETE FROM guest_calendar.event_attendees_by_owner "
                        + "where sailing_id = ? and "
                        + "event_owner_reservation_id = ? and "
                        + "event_owner_guest_id = ? and "
                        + "source_system_application_id = ? and "
                        + "source_system_offering_id = ?");
                BoundStatement boundAttendee = cancelQueryAttendee.bind(
                    shipSailDate, ownerReservationID, ownerGuestID,
                    sourceSystemApplicationID, sourceSystemOfferingID);
                session.executeAsync(boundAttendee);
            } else {
                cancelQueryAttendee = session.prepare(
                    "DELETE FROM guest_calendar.event_attendees_by_owner "
                        + "where sailing_id = ? and "
                        + "event_owner_reservation_id = ? and "
                        + "event_owner_guest_id = ? and "
                        + "source_system_application_id = ? and "
                        + "source_system_offering_id = ? and "
                        + "event_attendee_guest_id = ?");
                BoundStatement boundAttendee = cancelQueryAttendee.bind(
                    shipSailDate, ownerReservationID, ownerGuestID,
                    sourceSystemApplicationID, sourceSystemOfferingID,
                    guestsToRemove.get(0));
                session.executeAsync(boundAttendee);
            }

            for (String guestIDToRemove : guestsToRemove) {
                BoundStatement boundEvent = cancelQueryEvent.bind(shipSailDate,
                    guestIDToRemove, ownerReservationID, sourceSystemApplicationID, sourceSystemOfferingID);

                // ResultSetFuture cancelEventToBeCompleted =
                // session.executeAsync(boundEvent);
                // ResultSetFuture cancelAttendeeToBeCompleted =
                // session.executeAsync(boundAttendee);
                // logger.debug(cancelEventToBeCompleted.get());
                // logger.debug(cancelAttendeeToBeCompleted);
                session.executeAsync(boundEvent);
            }
        } catch (InterruptedException e) {
            logger.error(e.toString(), e);
        } catch (ExecutionException e) {
            logger.error(e.toString(), e);
        } catch (TimeoutException e) {
            logger.error(e.toString(), e);
            throw new BadRequest(TransportErrorCode.InternalServerError,
                new ExceptionMessage("error", "internal server error cas timeout"));
        } finally {
            stopWatch.stop();
            if (logger.isDebugEnabled()) {
                stopWatch.log();
            }
        }
    }

    private List<String> getAttendeeGuestIDs(
        final CassandraSession cassandraSession,
        final String shipSailDate,
        final String ownerReservationID,
        final String guestID,
        final String sourceSystemApplicationID,
        final String sourceSystemOfferingID) {
        List<String> guestsToRemove = new ArrayList<String>();
        com.datastax.driver.core.Session session;
        try {
            session = cassandraSession.underlying().toCompletableFuture()
                .get(TIMEOUT, TimeUnit.SECONDS);
            PreparedStatement selectAttendeeQuery = session.prepare(
                "SELECT * FROM guest_calendar.event_attendees_by_owner "
                    + "where sailing_id = ? and "
                    + "event_owner_reservation_id = ? and "
                    + "event_owner_guest_id = ? and "
                    + "source_system_application_id = ? and "
                    + "source_system_offering_id = ?");
            BoundStatement selectAttendees = selectAttendeeQuery.bind(
                shipSailDate, ownerReservationID, guestID,
                sourceSystemApplicationID, sourceSystemOfferingID);
            ResultSet attendees = session.execute(selectAttendees);
            for (Row one : attendees.all()) {
                guestsToRemove.add(one.getString("event_attendee_guest_id"));
            }
        } catch (InterruptedException e) {
            logger.error(e.toString(), e);
        } catch (ExecutionException e) {
            logger.error(e.toString(), e);
        } catch (TimeoutException e) {
            logger.error(e.toString(), e);
        }
        return guestsToRemove;
    }

    @Override
    protected void finalize() throws Throwable {
        gracefulStop(this.actor, Duration.create(
            ONE_MILLISECOND,
            TimeUnit.MILLISECONDS));
        super.finalize();
    }

}
