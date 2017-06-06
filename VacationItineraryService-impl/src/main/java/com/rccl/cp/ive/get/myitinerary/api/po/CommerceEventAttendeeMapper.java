package com.rccl.cp.ive.get.myitinerary.api.po;

import java.math.BigInteger;

import com.rccl.cp.ive.get.myitinerary.api.EventAttendee;
import com.rccl.cp.ive.get.myitinerary.api.ImmutableEventAttendee;

@FunctionalInterface
public interface CommerceEventAttendeeMapper {

    EventAttendee toEventAttendee(
        CommerceEventAttendee commerceEventAttendee);

    class CommerceEventAttendeeMapperImpl
        implements CommerceEventAttendeeMapper {
        @Override
        public EventAttendee toEventAttendee(final CommerceEventAttendee a) {
            return ImmutableEventAttendee.builder()
                .cruiseReservationID(BigInteger.valueOf(
                    Long.parseLong(
                        a.getEvent_attendee_cruise_reservation_id())))
                .guestID(BigInteger.valueOf(
                    Long.parseLong(a.getEvent_attendee_guest_id())))
                .sailingID(a.getSailing_id())
                .firstName(a.getEvent_attendee_first_name())
                .lastName(a.getEvent_attendee_last_name())
                .build();
        }
    }
}
