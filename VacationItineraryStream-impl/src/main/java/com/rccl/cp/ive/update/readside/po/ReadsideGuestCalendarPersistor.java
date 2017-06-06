package com.rccl.cp.ive.update.readside.po;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.BasicMessage;

public interface ReadsideGuestCalendarPersistor {
    void processUpdateEvent(CassandraSession cassandraSession,
        BasicMessage message);
    void processRemoveEvent(CassandraSession cassandraSession,
        String shipSailDate, String ownerGuestID, String ownerReservationID,
        String sourceSystemApplicationID, String sourceSystemOfferingID,
        String guestID, String eventType);
}
