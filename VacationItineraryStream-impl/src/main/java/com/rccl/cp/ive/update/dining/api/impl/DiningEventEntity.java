package com.rccl.cp.ive.update.dining.api.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.ImmutableEventLocation;
import com.rccl.cp.ive.update.common.ImmutableEventTime;
import com.rccl.cp.ive.update.dining.api.DiningEventMessage;
import com.rccl.cp.ive.update.readside.po.ReadsideGuestCalendarPersistor;

import akka.Done;

public class DiningEventEntity extends PersistentEntity<DiningEventCommand,
    DiningEventEvent, DiningEventState> {

    private Logger logger = LoggerFactory.getLogger(
        DiningEventEntity.class);

    private final CassandraSession cassandraSession;
    private ReadsideGuestCalendarPersistor processor;
    static final int MIN_LEN = 10;

    @Inject
    public DiningEventEntity(final CassandraSession session,
        @Named("DefaultGuestCalendarEventPersistor")
        final ReadsideGuestCalendarPersistor processr) {
        super();
        cassandraSession = session;
        this.processor = processr;
        // processor.setActorSystem(actorSystem);
    }

    private static final DiningEventState EMPTY_STATE =
        ImmutableDiningEventState.builder()
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

    @Override
    public final PersistentEntity<DiningEventCommand, DiningEventEvent,
        DiningEventState>.Behavior initialBehavior(
            final Optional<DiningEventState> snapshotState) {
        // to do Auto-generated method stub
        BehaviorBuilder b = newBehaviorBuilder(
            snapshotState.orElse(EMPTY_STATE));

        b.setCommandHandler(ImmutableUpdateDiningEventCommand.class,
            (ImmutableUpdateDiningEventCommand cmd, CommandContext<Done> ctx) -> {

                DiningEventMessage messageWithUUID = cmd.message();

                return ctx.thenPersist(ImmutableDiningEventUpdated.builder().message(messageWithUUID).build(),
                    evt -> {
                        if (logger.isDebugEnabled()) {
                            logger.debug("initialBehavior() EVENT PERSIST DONE "
                                + "{}", evt);
                        }
                        ctx.reply(Done.getInstance());
                    });
            });

        b.setEventHandler(ImmutableDiningEventUpdated.class,
            evt -> {
                logger.debug("dining event handler ImmutableDiningEventUpdated "
                    + " preparing state for {}", evt.getEntityId());
                DiningEventMessage m = evt.message().get();

                return ImmutableDiningEventState.builder()
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

        b.setCommandHandler(ImmutableRemoveDiningEventCommand.class,
            (cmd, ctx) -> {
                return ctx.thenPersist(
                    ImmutableDiningEventRemoved.builder()
                        .shipSailDate(cmd.shipSailDate())
                        .guestID(cmd.guestID())
                        .ownerGuestID(cmd.ownerGuestID())
                        .ownerReservationID(cmd.ownerReservationID())
                        .sourceSystemApplicationID(cmd.sourceSystemApplicationID())
                        .sourceSystemOfferingID(cmd.sourceSystemOfferingID())
                        .eventType(cmd.eventType())
                        .build(),
                    // Then once the event is successfully persisted,
                    // we respond with done.
                    evt -> {
                        logger.info("dining remove EVENT PERSIST DONE {}",
                            evt);
                        ctx.reply(Done.getInstance());
                    });
            });

        b.setEventHandler(ImmutableDiningEventRemoved.class,
            evt -> {
                logger.info("dining remove final state {}",
                    evt.getEntityId());

                return ImmutableDiningEventState.builder()
                    .from(EMPTY_STATE)
                    .shipSailDate(evt.shipSailDate())
                    .guestID(evt.guestID())
                    .eventType(evt.sourceSystemApplicationID())
                    .build();
            });
        return b.build();
    }

}
