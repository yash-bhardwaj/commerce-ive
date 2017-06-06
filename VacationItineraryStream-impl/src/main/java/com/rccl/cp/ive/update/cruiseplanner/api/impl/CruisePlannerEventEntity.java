package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.name.Named;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.ImmutableEventLocation;
import com.rccl.cp.ive.update.common.ImmutableEventTime;
import com.rccl.cp.ive.update.cruiseplanner.api.CruisePlannerEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;

import akka.Done;

/**
 * CruisePlannerEventEntity is uniquely identified by the following combination:
 * shipSailDate/guestId/sourceSystemApplicationId/sourceSystemOfferingId
 *
 * @author slu
 *
 */
public class CruisePlannerEventEntity extends PersistentEntity<
    CruisePlannerEventCommand, CruisePlannerEventEvent,
    CruisePlannerEventState> {
    private final CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor processor;

    private Logger logger = LoggerFactory.getLogger(
        CruisePlannerEventEntity.class);
    static final CruisePlannerEventState EMPTY_STATE =
        ImmutableCruisePlannerEventState.builder()
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
    public CruisePlannerEventEntity(final CassandraSession cassandraSessn,
        @Named("DefaultGuestCalendarEventPersistor")
        final ReadsideGuestCalendarPersistor processr) {
        super();
        this.cassandraSession = cassandraSessn;
        this.processor = processr;
    }

    @Override
    public final PersistentEntity<CruisePlannerEventCommand,
        CruisePlannerEventEvent,
        CruisePlannerEventState>.Behavior initialBehavior(
            final Optional<CruisePlannerEventState> snapshotState) {
        /*
         * Behaviour is defined using a behaviour builder. The behaviour builder
         * starts with a state, if this entity supports snapshotting (an
         * optimisation that allows the state itself to be persisted to combine
         * many events into one), then the passed in snapshotState may have a
         * value that can be used.
         *
         * Otherwise, the default state is to use the Hello greeting.
         */
        BehaviorBuilder b = newBehaviorBuilder(
            snapshotState.orElse(EMPTY_STATE));

        /*
         * Command handler for the UpdateCruisePlannerEventCommand.
         */
        b.setCommandHandler(ImmutableUpdateCruisePlannerEventCommand.class,
            (ImmutableUpdateCruisePlannerEventCommand cmd,
                CommandContext<Done> ctx) -> {
                // First validate if this command is eligible for persisting
                if (!CruisePlannerEventValidator.isValidUpdateCommand(cmd)) {
                    logger.error("Invalid command " + cmd);
                    ctx.invalidCommand("Command is invalid " + cmd);
                    return ctx.done();
                }
                CruisePlannerEventMessage messageWithUUID = cmd.message();

                // ImmutableCruisePlannerEventUpdated event
                return ctx.thenPersist(
                    ImmutableCruisePlannerEventUpdated.builder()
                        .message(messageWithUUID)
                        .build(),
                    // Then once the event is successfully persisted, we respond
                    // with done.
                    evt -> {
                        logger.info("initialBehavior() ENTITY PERSIST DONE {}",
                            evt);
                        ctx.reply(Done.getInstance());
                    });
            });

        /*
         * Event handler for the Immutable CruisePlannerEventUpdated event.
         */
        b.setEventHandler(ImmutableCruisePlannerEventUpdated.class,
            // We simply update the current state to use the greeting message
            // from the event.
            evt -> {
                logger.info("ImmutableCruisePlannerEventUpdated "
                    + "{}", evt.getEntityId());
                CruisePlannerEventMessage m = evt.message().get();

                return ImmutableCruisePlannerEventState.builder()
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
         * Command handler for the RempveCruisePlannerEventCommand.
         */
        b.setCommandHandler(ImmutableRemoveCruisePlannerEventCommand.class,
            (cmd, ctx) ->
            // In response to this command, we want to first persist it as a
            // ImmutableCruisePlannerEventUpdated event
            ctx.thenPersist(
                ImmutableCruisePlannerEventRemoved.builder()
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
         * Event handler for the Immutable CruisePlannerEventUpdated event.
         */
        b.setEventHandler(ImmutableCruisePlannerEventRemoved.class,
            // We simply update the current state to use the greeting message
            // from the event.
            evt -> {
                logger.info("ImmutableCruisePlannerEventRemoved "
                    + "remove {}", evt.getEntityId());

                return ImmutableCruisePlannerEventState.builder()
                    .from(EMPTY_STATE)
                    .shipSailDate(evt.shipSailDate())
                    .guestID(evt.guestID())
                    .eventType(evt.sourceSystemApplicationID())
                    .build();
            });

        return b.build();
    }

}
