package com.rccl.cp.ive.get.shipschedule.api.po;
import java.util.Optional;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventLocation;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventSourceDetail;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventTime;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableItineraryEvent;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;

@FunctionalInterface
public interface VoyageInfoToCalendarEventMapper {

    ItineraryEvent toItineraryEvent(
        VoyageInfoShipScheduleEvent guestCalendarEvent);

    class VoyageInfoToCalendarEventMapperImpl implements
        VoyageInfoToCalendarEventMapper {

        @Override
        public final ItineraryEvent toItineraryEvent(
            final VoyageInfoShipScheduleEvent e) {
            DateTimeFormatter dateFrom = DateTimeFormat.forPattern("yyyyMMdd");
            DateTimeFormatter dateTo = DateTimeFormat.forPattern("yyyy-MM-dd");
            DateTimeFormatter timeFrom = DateTimeFormat.forPattern("HHmmss");
            DateTimeFormatter timeTo = DateTimeFormat.forPattern("HH:mm");

            String[] arrivalDateTime = e.getArrival_datetime().split("T");
            String[] departureDateTime = e.getDeparture_datetime().split("T");

            String arrivalTime = "N/A";
            String departureTime = "N/A";
            if (!arrivalDateTime[1].equals("000000")) {
                arrivalTime = timeFrom.parseDateTime(String.valueOf(arrivalDateTime[1])).toString(timeTo);
            }
            if (!departureDateTime[1].equals("000000")) {
                departureTime = timeFrom.parseDateTime(String.valueOf(departureDateTime[1])).toString(timeTo);
            }
            return ImmutableItineraryEvent.builder()
                .eventLocale("en_US")
                .eventName(e.getPort_name())
                .eventType("SHIPSCHEDULE")
                .firstName("")
                .lastName("")
                .eventOwnerGuestID("")
                .eventGroupType("SHIPSCHEDULE")
                .eventGroupDescription("SHIPSCHEDULE")
                .eventStartTime(ImmutableEventTime.builder()
                    .eventDate(dateFrom.parseDateTime(
                        arrivalDateTime[0]).toString(dateTo))
                    .eventTime(arrivalTime)
                    .eventTimeZone(Optional.ofNullable("SHIP_TIME"))
                    .build())
                .eventEndTime(ImmutableEventTime.builder()
                    .eventDate(dateFrom.parseDateTime(
                        departureDateTime[0]).toString(dateTo))
                    .eventTime(departureTime)
                    .eventTimeZone(Optional.ofNullable("SHIP_TIME"))
                    .build())
                .sourceDetail(ImmutableEventSourceDetail.builder()
                    .sourceSystemApplicationID("SHIPSCHEDULE")
                    .sourceSystemOfferingID(e.getItinerary_code())
                    .sourceSystemOrderID(Optional.ofNullable(null))
                    .sourceSystemProductID(Optional.ofNullable(null))
                    .sourceSystemProductName(Optional.ofNullable(
                        e.getVoyage_description()))
                    .sourceSystemExternalOrderID(Optional.ofNullable(null))
                    .sourceSystemReservationID(null)
                    .build())
                .eventLocation(ImmutableEventLocation.builder()
                    .locationCode(e.getPort_code())
                    .locationType(e.getEvent_type())
                    .locationName(Optional.ofNullable(e.getPort_name()))
                    .build())
                .build();
        }
    }
}
