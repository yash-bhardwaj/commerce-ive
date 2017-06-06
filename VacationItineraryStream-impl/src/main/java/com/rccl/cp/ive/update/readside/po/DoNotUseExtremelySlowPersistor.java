package com.rccl.cp.ive.update.readside.po;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.BasicMessage;

public class DoNotUseExtremelySlowPersistor implements
    ReadsideGuestCalendarPersistor {

    private Logger logger = LoggerFactory.getLogger(
        DoNotUseExtremelySlowPersistor.class);
    private static final int SLEEP_INTERVAL = 7000;

    @Override
    public final void processUpdateEvent(
        final CassandraSession cassandraSession,
        final BasicMessage message) {
        try {
            logBadMessage();
            Thread.sleep(SLEEP_INTERVAL);
        } catch (Exception e) {
            logger.error("processUpdateEvent(): Got Exception: {}",
                e.getMessage());
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
        try {
            logBadMessage();
            Thread.sleep(SLEEP_INTERVAL);
        } catch (Exception e) {
            logger.error("processRemoveEvent(): Got Exception: {}",
                e.getMessage());
        }
    }

    private void logBadMessage() {
        logger.error("BAD BAD BAD");
        logger.error(" /     \\");
        logger.error("| () () |");
        logger.error(" \\  ^  /");
        logger.error("  |||||");
        logger.error("  |||||");
        logger.error("YOU ARE USING A BUGGY PERSISTOR");
    }
}
