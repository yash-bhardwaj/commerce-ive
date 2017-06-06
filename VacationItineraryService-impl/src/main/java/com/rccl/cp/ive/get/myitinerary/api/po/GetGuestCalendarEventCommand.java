package com.rccl.cp.ive.get.myitinerary.api.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;

public class GetGuestCalendarEventCommand extends
    HystrixCommand<Map<String, List<ItineraryEvent>>> {

    private boolean secondTry = false;
    private CassandraSession cassandraSession;
    private String shipSailDate;
    private String cruiseBookingID;
    private String guestID;
    private static final Integer HYSTRIX_GROUP_DEFAULT_KEY = 3000;
    private GetGuestCalendarEventHydrator hydrator =
        new GetGuestCalendarEventHydrator();

    private final Logger logger = LoggerFactory.getLogger(
        GetGuestCalendarEventCommand.class);

    public GetGuestCalendarEventCommand(final CassandraSession cassandraSess,
        final String sailDate, final String bookingId,
        final String guestId) {
        super(HystrixCommandGroupKey.Factory.asKey("default"),
            HYSTRIX_GROUP_DEFAULT_KEY);
        this.cassandraSession = cassandraSess;
        this.shipSailDate = sailDate;
        this.cruiseBookingID = bookingId;
        this.guestID = guestId;
    }

    @Override
    protected final Map<String, List<ItineraryEvent>> run() throws Exception {
        try {
            return hydrator.getGuestCalendarEvent(cassandraSession, shipSailDate,
                cruiseBookingID, guestID);
        } catch (Exception e) {
            logger.error("Retrying event: [shipSailDate: "
                + shipSailDate + ", cruiseBookingID: " + cruiseBookingID
                + ", guestID: " + guestID + "] in 1 second.");
            Thread.sleep(1000);
            return hydrator.getGuestCalendarEvent(cassandraSession, shipSailDate,
                cruiseBookingID, guestID);
        }
    }

    @Override
    protected final Map<String, List<ItineraryEvent>> getFallback() {
        logger.error("Failure while processing event: [shipSailDate: "
            + shipSailDate + ", cruiseBookingID: " + cruiseBookingID
            + ", guestID: " + guestID + "]");

        logger.debug("Failed. " + getExecutionException());
        // if (getExecutionException() instanceof
        // com.netflix.hystrix.exception.HystrixTimeoutException) {
        // logger.error("TEST");
        // }
        // Need to do: Return a well formed error here

        Map<String, List<ItineraryEvent>> errorMap =
            new HashMap<String, List<ItineraryEvent>>();
        errorMap.put("ERROR: " + getExecutionException(), null);
        
        return errorMap;
    }

}
