package com.rccl.cp.ive.get.myitinerary.api.po;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.rccl.cp.ive.get.shipschedule.api.po.VoyageInfoShipScheduleEvent;

@Accessor
public interface CommerceGuestCalendarEventAccessor {

    @Query("SELECT * FROM guest_calendar.calendar_events_by_guest")
    Result<CommerceGuestCalendarEvent> getAll();

    @Query("select * from guest_calendar.calendar_events_by_guest "
        + "where sailing_id = ? and "
        + "guest_id = ? and "
        + "source_system_reservation_id > ''")
    Result<CommerceGuestCalendarEvent> getBySailingIDGuestID(
        String sailingID, String guestID);

    @Query("select * from guest_calendar.event_attendees_by_owner "
        + "where sailing_id = ? and event_owner_reservation_id = ? "
        + "and event_owner_guest_id = ? and "
        + "source_system_application_id = ? and "
        + "source_system_offering_id = ?")
    Result<CommerceEventAttendee> getAttendeesForEvent(
        final String sailingID,
        final String ownerReservationID,
        final String ownerGuestID,
        final String systemApplicationID,
        final String systemOfferingID);

    @Query("select * from "
        + "guest_calendar.shipsailinfo_by_shipcode_and_saildate_v1 "
        + "where ship_code = ? and sail_date = ?")
    Result<VoyageInfoShipScheduleEvent> getShipScheduleByShipSailDate(
        final String shipCode, final String sailDate);
}
