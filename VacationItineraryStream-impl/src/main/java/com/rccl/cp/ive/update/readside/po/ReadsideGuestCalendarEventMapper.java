package com.rccl.cp.ive.update.readside.po;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.LocalDate;
import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.EventSourceDetail;

@FunctionalInterface
public interface ReadsideGuestCalendarEventMapper {

    ReadsideGuestCalendarEvent toReadsideGuestCalendarEvent(
        BasicMessage message, EventAttendee attendee);
    Logger LOGGER = LoggerFactory.getLogger(
        ReadsideGuestCalendarEventMapper.class);

    class ReadsideGuestCalendarEventMapperImpl
        implements ReadsideGuestCalendarEventMapper {

        @Override
        public final ReadsideGuestCalendarEvent
            toReadsideGuestCalendarEvent(final BasicMessage m,
                final EventAttendee attendee) {
            ReadsideGuestCalendarEvent e = new ReadsideGuestCalendarEvent();
            // if (LOGGER.isDebugEnabled()) {
            // LOGGER.debug("toReadsideGuestCalendarEvent() "
            // + "Converting message to PO {}", m);
            // }
            e.setCruise_reservation_id(attendee.cruiseReservationID());
            e.setGuest_id(attendee.guestID());
            e.setFirst_name(attendee.firstName());
            e.setLast_name(attendee.lastName());
            e.setEvent_owner_reservation_id(m.sourceDetail().sourceSystemReservationID());
            e.setEvent_owner_guest_id(m.guestID());
            if (m.eventName().isPresent()) {
                e.setEvent_name(m.eventName().get());
            }
            java.time.LocalDate javaDate =
                java.time.LocalDate.parse(m.eventEndTime().eventDate());
            e.setEvent_end_date(LocalDate.fromYearMonthDay(javaDate.getYear(),
                javaDate.getMonthValue(), javaDate.getDayOfMonth()));
            e.setEvent_end_time(LocalTime.parse(
                m.eventEndTime().eventTime()).toNanoOfDay());
            if (m.eventEndTime().eventTimeZone().isPresent()) {
                e.setEvent_end_time_zone(
                    m.eventEndTime().eventTimeZone().get());
            }
            e.setEvent_group_description(m.eventGroupDescription());
            e.setEvent_group_type(m.eventGroupType());
            e.setEvent_locale(m.eventLocale().get());
            javaDate = java.time.LocalDate.parse(
                m.eventStartTime().eventDate());
            e.setEvent_start_date(LocalDate.fromYearMonthDay(
                javaDate.getYear(), javaDate.getMonthValue(),
                javaDate.getDayOfMonth()));
            e.setEvent_start_time(LocalTime.parse(
                m.eventStartTime().eventTime()).toNanoOfDay());
            if (m.eventStartTime().eventTimeZone().isPresent()) {
                e.setEvent_start_time_zone(
                    m.eventStartTime().eventTimeZone().get());
            }
            e.setEvent_location_code(m.eventLocation().locationCode());
            e.setEvent_location_type(m.eventLocation().locationType());
            if (m.eventLocation().locationName().isPresent()) {
                e.setEvent_location_name(
                    m.eventLocation().locationName().get());
            }
            e.setSailing_id(m.shipSailDate());
            e.setEvent_type(m.eventType());
            EventSourceDetail sourceSystem = m.sourceDetail();
            e.setSource_system_application_id(
                sourceSystem.sourceSystemApplicationID());
            e.setSource_system_offering_id(
                sourceSystem.sourceSystemOfferingID());
            if (sourceSystem.sourceSystemExternalOrderID().isPresent()) {
                e.setSource_system_external_order_id(
                    sourceSystem.sourceSystemExternalOrderID().get());
            }
            if (sourceSystem.sourceSystemOrderID().isPresent()) {
                e.setSource_system_order_id(
                    sourceSystem.sourceSystemOrderID().get());
            }
            if (sourceSystem.sourceSystemProductID().isPresent()) {
                e.setSource_system_product_id(
                    sourceSystem.sourceSystemProductID().get());
            }
            if (sourceSystem.sourceSystemProductName().isPresent()) {
                e.setSource_system_product_name(
                    sourceSystem.sourceSystemProductName().get());
            }
            e.setSource_system_reservation_id(
                sourceSystem.sourceSystemReservationID());

            return e;
        }
    }
}
