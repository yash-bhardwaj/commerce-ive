package com.rccl.cp.ive.get.myitinerary.api.po;

import com.rccl.cp.ive.get.myitinerary.api.ImmutableItineraryEventForDisplay;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEvent;
import com.rccl.cp.ive.get.myitinerary.api.ItineraryEventForDisplay;

@FunctionalInterface
public interface CommerceGuestCalendarEventForDisplayMapper {

    ItineraryEventForDisplay toItineraryEventForDisplay(
        ItineraryEvent guestCalendarEvent);

    class CommerceGuestCalendarEventForDisplayMapperImpl implements
        CommerceGuestCalendarEventForDisplayMapper {

        @Override
        public ItineraryEventForDisplay toItineraryEventForDisplay(
            final ItineraryEvent e) {
            return ImmutableItineraryEventForDisplay.builder()
                .eventLocale(e.eventLocale())
                .eventOwnerGuestID(e.eventOwnerGuestID())
                .eventName(e.eventName())
                .eventType(e.eventType())
                .eventEndTime(e.eventEndTime())
                .eventStartTime(e.eventStartTime())
                .sourceDetail(e.sourceDetail())
                .eventLocation(e.eventLocation())
                .attendees(e.attendees())
                .links(e.links())
                .build();
        }
    }
}
