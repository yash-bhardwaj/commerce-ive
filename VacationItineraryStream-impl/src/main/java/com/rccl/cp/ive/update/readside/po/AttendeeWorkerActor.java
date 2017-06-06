package com.rccl.cp.ive.update.readside.po;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;

import akka.actor.UntypedActor;
import akka.japi.pf.ReceiveBuilder;

public class AttendeeWorkerActor extends UntypedActor {

    private Logger logger = LoggerFactory.getLogger(AttendeeWorkerActor.class);
    private final CassandraSession cassandraSession;
    private static final int TIMEOUT = 3;

    public AttendeeWorkerActor(final CassandraSession session) {
        this.cassandraSession = session;
        ReceiveBuilder.match(AttendeeUpdateMessage.class,
            this::updateSmallBatchAttendees).build();
    }

    private void updateSmallBatchAttendees(
        final AttendeeUpdateMessage attendeeMessage) {
        // if (logger.isDebugEnabled())
        // logger.debug(attendeeMessage.toString());
        Profiler stopWatch = new Profiler(
            "AttendeeWorkerActor.updateForOneAttendee");
        stopWatch.setLogger(logger);
        com.datastax.driver.core.Session session;
        try {
            session = cassandraSession.underlying().toCompletableFuture().get(
                TIMEOUT, TimeUnit.SECONDS);
            if (session == null) {
                logger.debug("null cassandra session. readside process abort");
                return;
            }
            MappingManager manager = new MappingManager(session);
            Mapper<ReadsideGuestCalendarEvent> guestCalendarEventMapper =
                manager.mapper(ReadsideGuestCalendarEvent.class);
            Mapper<ReadsideEventAttendee> attendeeMapper =
                manager.mapper(ReadsideEventAttendee.class);
            ReadsideGuestCalendarEventMapper pojoEventMapper =
                new ReadsideGuestCalendarEventMapper.ReadsideGuestCalendarEventMapperImpl();
            ReadsideEventAttendeeMapper pojoAttendeeMapper =
                new ReadsideEventAttendeeMapper.ReadsideEventAttendeeMapperImpl();
            // for each attendees plus owner, store to the event table
            // and attendee table map and persisting
            attendeeMessage.getAttendees().parallelStream().forEach(
                attendee -> {
                    ReadsideGuestCalendarEvent guestCalendarEvent =
                        pojoEventMapper.toReadsideGuestCalendarEvent(
                            attendeeMessage.getMessage(), attendee);
                    guestCalendarEventMapper.save(guestCalendarEvent);
                    ReadsideEventAttendee attendeeToSave =
                        pojoAttendeeMapper.toReadsideEventAttendee(attendee,
                            attendeeMessage.getMessage());
                    attendeeMapper.save(attendeeToSave);
                });
        } catch (InterruptedException | ExecutionException
            | TimeoutException e) {
            logger.error(e.toString());
        } finally {
            stopWatch.stop();
            if (logger.isInfoEnabled()) {
                stopWatch.log();
            }
        }
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        updateSmallBatchAttendees((AttendeeUpdateMessage) message);
        getSender().tell("Done", getSelf());
    }
}
