package com.rccl.cp.ive.update.common;

import java.util.List;
import java.util.Optional;

public interface BasicMessage {

    Optional<String> method();
    String shipSailDate();
    String cruiseBookingID();
    String guestID();
    Optional<String> firstName();
    Optional<String> lastName();
    String eventGroupType();
    String eventGroupDescription();
    String eventType();
    Optional<String> eventLocale();
    Optional<String> eventName();
    EventLocation eventLocation();
    EventTime eventStartTime();
    EventTime eventEndTime();
    EventSourceDetail sourceDetail();
    Optional<List<EventAttendee>> attendees();

}
