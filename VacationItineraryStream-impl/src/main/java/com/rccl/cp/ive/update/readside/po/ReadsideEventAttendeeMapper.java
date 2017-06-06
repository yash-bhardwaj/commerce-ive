package com.rccl.cp.ive.update.readside.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;

@FunctionalInterface
public interface ReadsideEventAttendeeMapper {

    List<ReadsideEventAttendee> toReadsideEventAttendees(
        List<EventAttendee> rotatedAttendees,
        BasicMessage originalOwnerEvent);

    default ReadsideEventAttendee toReadsideEventAttendee(
        EventAttendee attendee, BasicMessage m) {
        ReadsideEventAttendee commerceAttendee = new ReadsideEventAttendee();
        commerceAttendee.setEvent_attendee_cruise_reservation_id(
            attendee.cruiseReservationID());
        commerceAttendee.setSailing_id(attendee.sailingID());
        commerceAttendee.setEvent_attendee_guest_id(attendee.guestID());
        commerceAttendee.setSource_system_application_id(m.sourceDetail()
            .sourceSystemApplicationID());
        commerceAttendee.setSource_system_offering_id(m.sourceDetail()
            .sourceSystemOfferingID());
        commerceAttendee.setEvent_owner_guest_id(m.guestID());
        commerceAttendee.setEvent_attendee_first_name(attendee.firstName());
        commerceAttendee.setEvent_attendee_last_name(attendee.lastName());
        commerceAttendee.setEvent_owner_reservation_id(
            m.sourceDetail().sourceSystemReservationID());
        return commerceAttendee;
    }

    class ReadsideEventAttendeeMapperImpl implements
        ReadsideEventAttendeeMapper {

        @Override
        public final List<ReadsideEventAttendee> toReadsideEventAttendees(
            final List<EventAttendee> rotatedAttendees,
            final BasicMessage originalOwnerEvent) {
            if (rotatedAttendees != null) {
                return rotatedAttendees.stream()
                    .map(attendee -> {
                        return toReadsideEventAttendee(attendee,
                            originalOwnerEvent);
                    }).collect(Collectors.toList());

            } else {
                return Collections.unmodifiableList(new ArrayList<ReadsideEventAttendee>());
            }
        }
    }
}
