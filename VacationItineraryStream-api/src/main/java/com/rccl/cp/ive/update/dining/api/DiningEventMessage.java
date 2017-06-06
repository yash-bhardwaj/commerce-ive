package com.rccl.cp.ive.update.dining.api;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.EventLocation;
import com.rccl.cp.ive.update.common.EventSourceDetail;
import com.rccl.cp.ive.update.common.EventTime;

@Value.Immutable
@JsonSerialize(as = ImmutableDiningEventMessage.class)
@JsonDeserialize(as = ImmutableDiningEventMessage.class)
public interface DiningEventMessage extends BasicMessage {
    @Override
    Optional<String> method();
    @Override
    String shipSailDate();
    @Override
    String cruiseBookingID();
    @Override
    String guestID();
    @Override
    Optional<String> firstName();
    @Override
    Optional<String> lastName();
    @Override
    String eventGroupType();
    @Override
    String eventGroupDescription();
    @Override
    String eventType();
    @Override
    Optional<String> eventLocale();
    @Override
    Optional<String> eventName();
    @Override
    EventLocation eventLocation();
    @Override
    EventTime eventStartTime();
    @Override
    EventTime eventEndTime();
    @Override
    EventSourceDetail sourceDetail();
    @Override
    Optional<List<EventAttendee>> attendees();
}
