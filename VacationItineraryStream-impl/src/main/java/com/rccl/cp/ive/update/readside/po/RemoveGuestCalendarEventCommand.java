package com.rccl.cp.ive.update.readside.po;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class RemoveGuestCalendarEventCommand extends HystrixCommand<Void> {

    private CassandraSession cassandraSession;
    private String shipSailDate;
    private String ownerReservationID;
    private String guestID;
    private String ownerGuestID;
    private String sourceSystemApplicationID;
    private String sourceSystemOfferingID;
    // private DoNotUseExtremelySlowPersistor processor =
    // new DoNotUseExtremelySlowPersistor();
    private ReadsideGuestCalendarPersistor processor;
    private String eventType;
    static final int MS_TIMEOUT = 3000;

    private Logger logger = LoggerFactory.getLogger(
        RemoveGuestCalendarEventCommand.class);

    public RemoveGuestCalendarEventCommand(
        final CassandraSession cassandraSession,
        final String shipSailDate,
        final String ownerReservationID,
        final String ownerGuestID,
        final String sourceSystemApplicationID,
        final String sourceSystemOfferingID,
        final String guestID,
        final String eventType,
        final ReadsideGuestCalendarPersistor processor) {
        super(HystrixCommandGroupKey.Factory.asKey("default"), MS_TIMEOUT);
        this.cassandraSession = cassandraSession;
        this.shipSailDate = shipSailDate;
        this.ownerReservationID = ownerReservationID;
        this.ownerGuestID = ownerGuestID;
        this.sourceSystemApplicationID = sourceSystemApplicationID;
        this.sourceSystemOfferingID = sourceSystemOfferingID;
        this.guestID = guestID;
        this.eventType = eventType;
        this.processor = processor;
    }

    @Override
    protected final Void run() throws Exception {
        processor.processRemoveEvent(cassandraSession, shipSailDate,
            ownerReservationID, ownerGuestID, sourceSystemApplicationID,
            sourceSystemOfferingID, guestID, eventType);
        return null;
    }

    @Override
    protected final Void getFallback() {
        logger.error("Failure while processing event: [shipSaildate: "
            + shipSailDate + ", guestID: " + guestID + ", ownerGuestID: "
            + ownerGuestID + ", sourceSystemApplicationID: "
            + sourceSystemApplicationID + ", sourceSystemOfferingID: "
            + sourceSystemOfferingID + "]");
        logger.error("Failed. " + getExecutionException());
        // to do: Return a well formed error here
        return null;
    }
}
