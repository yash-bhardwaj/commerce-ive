package com.rccl.cp.ive.get.myitinerary.api.po;

import java.util.Optional;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.collect.ImmutableList;
import com.rccl.cp.ive.get.myitinerary.api.EventAttendee;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventLocation;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventSourceDetail;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventTime;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableItineraryEvent;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableItineraryLink;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryLink;

@FunctionalInterface
public interface CommerceGuestCalendarEventMapper {

    ItineraryEvent toItineraryEvent(
        CommerceGuestCalendarEvent guestCalendarEvent);

    class CommerceGuestCalendarEventMapperImpl implements
        CommerceGuestCalendarEventMapper {

        @Override
        public final ItineraryEvent toItineraryEvent(
            final CommerceGuestCalendarEvent e) {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
            return ImmutableItineraryEvent.builder()
                .eventLocale(e.getEvent_locale())
                .eventName(e.getEvent_name())
                .eventType(e.getEvent_type())
                .firstName(e.getFirst_name())
                .lastName(e.getLast_name())
                .eventOwnerGuestID(e.getEvent_owner_guest_id())
                .eventGroupType(e.getEvent_group_type())
                .eventGroupDescription(e.getEvent_group_description())
                .eventStartTime(ImmutableEventTime.builder()
                    .eventDate(e.getEvent_start_date().toString())
                    .eventTime(e.getEvent_start_time().toString(fmt))
                    .eventTimeZone(Optional.ofNullable(
                        e.getEvent_start_time_zone()))
                    .build())
                .eventEndTime(ImmutableEventTime.builder()
                    .eventDate(e.getEvent_end_date().toString())
                    .eventTime(e.getEvent_end_time().toString(fmt))
                    .eventTimeZone(Optional.ofNullable(
                        e.getEvent_end_time_zone()))
                    .build())
                .sourceDetail(ImmutableEventSourceDetail.builder()
                    .sourceSystemApplicationID(
                        e.getSource_system_application_id())
                    .sourceSystemOfferingID(
                        e.getSource_system_offering_id())
                    .sourceSystemOrderID(Optional.ofNullable(
                        e.getSource_system_order_id()))
                    .sourceSystemProductID(Optional.ofNullable(
                        e.getSource_system_product_id()))
                    .sourceSystemProductName(Optional.ofNullable(
                        e.getSource_system_product_name()))
                    .sourceSystemExternalOrderID(Optional.ofNullable(
                        e.getSource_system_external_order_id()))
                    .sourceSystemReservationID(
                        e.getSource_system_reservation_id())
                    .build())
                .eventLocation(ImmutableEventLocation.builder()
                    .locationCode(e.getEvent_location_code())
                    .locationType(e.getEvent_location_type())
                    .locationName(Optional.ofNullable(
                        e.getEvent_location_name()))
                    .build())
                .attendees(ImmutableList.<EventAttendee>builder().addAll(
                    e.getAttendees()).build())
                .links(ImmutableList.<ItineraryLink>builder().add(
                    ImmutableItineraryLink.builder()
                        .rel("deleteEvent")
                        .href("/api/v1/events/"
                            + getLinkCategory(e.getEvent_group_type())
                            + "/" + e.getSailing_id() + "/"
                            + e.getGuest_id() + "/"
                            + e.getEvent_owner_guest_id() + "/"
                            + e.getSource_system_reservation_id() + "/"
                            + e.getSource_system_application_id() + "/"
                            + e.getSource_system_offering_id())
                        .build())
                    .build())
                .build();
        }

        private String getLinkCategory(final String eventGroupType) {
            String linkCategory = "commerce";
            if (eventGroupType.equalsIgnoreCase("CRUISECOMPASS")) {
                linkCategory = "cruisecompass";
            } else if (eventGroupType.equalsIgnoreCase("SELF")) {
                linkCategory = "self";
            } else if (eventGroupType.equalsIgnoreCase("DINING")) {
                linkCategory = "dining";
            }
            return linkCategory;
        }

    }
}
