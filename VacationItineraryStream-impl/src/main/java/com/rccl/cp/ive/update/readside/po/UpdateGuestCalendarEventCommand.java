package com.rccl.cp.ive.update.readside.po;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.rccl.cp.ive.update.common.BasicMessage;

public class UpdateGuestCalendarEventCommand extends HystrixCommand<Void> {

    private CassandraSession cassandraSession;
    private BasicMessage message;
    // private DoNotUseExtremelySlowPersistor processor =
    // new DoNotUseExtremelySlowPersistor();
    private ReadsideGuestCalendarPersistor processor;
    static final int MS_TIMEOUT = 3000;

    private Logger logger = LoggerFactory.getLogger(
        UpdateGuestCalendarEventCommand.class);

    public UpdateGuestCalendarEventCommand(
        final CassandraSession session,
        final BasicMessage msg,
        final ReadsideGuestCalendarPersistor processr) {
        super((HystrixCommandGroupKey) (HystrixCommandGroupKey.Factory
            .asKey("default")),
            MS_TIMEOUT);
        this.cassandraSession = session;
        this.message = msg;
        this.processor = processr;
    }

    @Override
    protected final Void run() throws Exception {
        processor.processUpdateEvent(cassandraSession, message);
        return null;
    }

    @Override
    protected final Void getFallback() {
        logger.error("Failure while processing event: [shipSaildate: "
            + message.shipSailDate() + ", guestID: " + message.guestID()
            + ", sourceSystemApplicationID: "
            + message.sourceDetail().sourceSystemApplicationID()
            + ", sourceSystemOfferingID: "
            + message.sourceDetail().sourceSystemOfferingID() + "]");
        logger.debug("Failed. " + getExecutionException());
        // to do: Return a well formed error here
        return null;
    }

}
