package com.rccl.cp.ive.update.cruisecompass.api.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.name.Named;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.ImmutableEventLocation;
import com.rccl.cp.ive.update.common.ImmutableEventTime;
import com.rccl.cp.ive.update.cruisecompass.api.CruiseCompassEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;

import akka.Done;

/**
 * CruiseCompassEventEntity is uniquely identified by the following combination:
 * shipSailDate/guestId/sourceSystemApplicationId/sourceSystemOfferingId
 *
 * @author slu
 *
 */
public class CruiseCompassEventEntity extends
    PersistentEntity<CruiseCompassEventCommand, CruiseCompassEventEvent,
        CruiseCompassEventState> {

    private final CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor processor;
    private Logger logger =
        LoggerFactory.getLogger(CruiseCompassEventEntity.class);
    static final CruiseCompassEventState EMPTY_STATE =
        ImmutableCruiseCompassEventState.builder()
            .shipSailDate("")
            .cruiseBookingID("")
            .guestID("")
            .eventType("")
            .eventStartTime(
                ImmutableEventTime.builder()
                    .eventDate("")
                    .eventTime("")
                    .build())
            .eventEndTime(
                ImmutableEventTime.builder()
                    .eventDate("")
                    .eventTime("")
                    .build())
            .eventLocation(
                ImmutableEventLocation.builder()
                    .locationCode("")
                    .locationType("")
                    .build())
            .build();

    @Inject
    public CruiseCompassEventEntity(final CassandraSession cassandraSess,
        @Named("DefaultGuestCalendarEventPersistor")
        final ReadsideGuestCalendarPersistor persistor) {
        super();
        this.cassandraSession = cassandraSess;
        this.processor = persistor;
    }

    @Override
    public final PersistentEntity<CruiseCompassEventCommand,
        CruiseCompassEventEvent, CruiseCompassEventState>.Behavior
        initialBehavior(final Optional<CruiseCompassEventState> snapshotState) {
        /*
         * Behaviour is defined using a behaviour builder. This builder starts
         * with a state, if this entity supports snapshotting (an optimisation
         * that allows state itself to be persisted to combine many events into
         * one), then the passed in snapshotState may have a value that can be
         * used.
         *
         * Otherwise, the default state is to use the Hello greeting.
         */
        BehaviorBuilder b = newBehaviorBuilder(
            snapshotState.orElse(EMPTY_STATE));

        /*
         * Command handler for the UpdateCruiseCompassEventCommand.
         */
        b.setCommandHandler(ImmutableUpdateCruiseCompassEventCommand.class,
            (ImmutableUpdateCruiseCompassEventCommand cmd,
                CommandContext<Done> ctx) -> {
                // First validate if this command is eligible for persisting
                if (!CruiseCompassEventValidator.isValidUpdateCommand(cmd)) {
                    logger.error("Invalid command " + cmd);
                    ctx.invalidCommand("Command is invalid " + cmd);
                    return ctx.done();
                }
                CruiseCompassEventMessage messageWithUUID = cmd.message();
                // ImmutableCruiseCompassEventUpdated event
                return ctx.thenPersist(
                    ImmutableCruiseCompassEventUpdated.builder()
                        .message(messageWithUUID)
                        .build(),
                    // Then once the event is successfully persisted,
                    // we respond with done.
                    evt -> {
                        logger.info("initialBehavior() ENTITY PERSIST DONE {}",
                            evt);
                        ctx.reply(Done.getInstance());
                    });
            });

        /*
         * Event handler for the Immutable CruiseCompassEventUpdated event.
         */
        b.setEventHandler(ImmutableCruiseCompassEventUpdated.class,
            // We simply update the current state to use the greeting message
            // from the event.
            evt -> {
                if (logger.isDebugEnabled()) {
                    logger.debug("ImmutableCruiseCompassEventUpdated "
                        + "{}", evt.getEntityId());
                }
                CruiseCompassEventMessage m = evt.message().get();

                return ImmutableCruiseCompassEventState.builder()
                    .cruiseBookingID(m.cruiseBookingID())
                    .shipSailDate(m.shipSailDate())
                    .guestID(m.guestID())
                    .eventType(m.eventType())
                    .eventLocale(m.eventLocale())
                    .eventName(m.eventName())
                    .eventLocation(m.eventLocation())
                    .eventStartTime(m.eventStartTime())
                    .eventEndTime(m.eventEndTime())
                    .sourceDetail(m.sourceDetail())
                    .attendees(m.attendees().get())
                    .build();
            });

        /*
         * Command handler for the RempveCruiseCompassEventCommand.
         */
        b.setCommandHandler(ImmutableRemoveCruiseCompassEventCommand.class,
            (cmd, ctx) ->
            // In response to this command, we want to first persist it as a
            // ImmutableCruiseCompassEventUpdated event
            ctx.thenPersist(
                ImmutableCruiseCompassEventRemoved.builder()
                    .shipSailDate(cmd.shipSailDate())
                    .guestID(cmd.guestID())
                    .ownerGuestID(cmd.ownerGuestID())
                    .ownerReservationID(cmd.ownerReservationID())
                    .sourceSystemApplicationID(cmd.sourceSystemApplicationID())
                    .sourceSystemOfferingID(cmd.sourceSystemOfferingID())
                    .eventType(cmd.eventType())
                    .build(),
                // Then once the event is successfully persisted, we respond
                // with done.
                evt -> {
                    logger.info("initialBehavior() ENTITY PERSIST DONE {}",
                        evt);
                    ctx.reply(Done.getInstance());
                }));

        /*
         * Event handler for the Immutable CruiseCompassEventUpdated event.
         */
        b.setEventHandler(ImmutableCruiseCompassEventRemoved.class,
            // We simply update the current state to use the greeting message
            // from the event.
            evt -> {
                if (logger.isDebugEnabled()) {
                    logger.debug("ImmutableCruiseCompassEventRemoved "
                        + " remove {}", evt.getEntityId());
                }

                return ImmutableCruiseCompassEventState.builder().from(
                    EMPTY_STATE)
                    .shipSailDate(evt.shipSailDate())
                    .guestID(evt.guestID())
                    .eventType(evt.sourceSystemApplicationID())
                    .build();
            });

        return b.build();
    }

}
