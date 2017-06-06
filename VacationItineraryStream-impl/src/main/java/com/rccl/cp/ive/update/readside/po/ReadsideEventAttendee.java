package com.rccl.cp.ive.update.readside.po;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "guest_calendar", name = "event_attendees_by_owner",
    readConsistency = "QUORUM",
    writeConsistency = "QUORUM",
    caseSensitiveKeyspace = false,
    caseSensitiveTable = false)
public class ReadsideEventAttendee {

    @PartitionKey(0)
    private String sailing_id;
    @PartitionKey(1)
    private String event_owner_reservation_id;
    @ClusteringColumn(0)
    private String event_owner_guest_id;
    @ClusteringColumn(1)
    private String source_system_application_id;
    @ClusteringColumn(2)
    private String source_system_offering_id;
    @ClusteringColumn(3)
    private String event_attendee_guest_id;
    private String event_attendee_cruise_reservation_id;
    private String event_attendee_first_name;
    private String event_attendee_last_name;

    public String getSailing_id() {
        return sailing_id;
    }
    public void setSailing_id(String sailing_id) {
        this.sailing_id = sailing_id;
    }
    public String getEvent_owner_reservation_id() {
        return event_owner_reservation_id;
    }
    public void setEvent_owner_reservation_id(String event_owner_reservation_id) {
        this.event_owner_reservation_id = event_owner_reservation_id;
    }
    public String getEvent_owner_guest_id() {
        return event_owner_guest_id;
    }
    public void setEvent_owner_guest_id(String event_owner_guest_id) {
        this.event_owner_guest_id = event_owner_guest_id;
    }
    public String getSource_system_application_id() {
        return source_system_application_id;
    }
    public void setSource_system_application_id(String source_system_application_id) {
        this.source_system_application_id = source_system_application_id;
    }
    public String getSource_system_offering_id() {
        return source_system_offering_id;
    }
    public void setSource_system_offering_id(String source_system_offering_id) {
        this.source_system_offering_id = source_system_offering_id;
    }
    public String getEvent_attendee_guest_id() {
        return event_attendee_guest_id;
    }
    public void setEvent_attendee_guest_id(String event_attendee_guest_id) {
        this.event_attendee_guest_id = event_attendee_guest_id;
    }
    public String getEvent_attendee_cruise_reservation_id() {
        return event_attendee_cruise_reservation_id;
    }
    public void setEvent_attendee_cruise_reservation_id(String event_attendee_cruise_reservation_id) {
        this.event_attendee_cruise_reservation_id = event_attendee_cruise_reservation_id;
    }
    public String getEvent_attendee_first_name() {
        return event_attendee_first_name;
    }
    public void setEvent_attendee_first_name(String event_attendee_first_name) {
        this.event_attendee_first_name = event_attendee_first_name;
    }
    public String getEvent_attendee_last_name() {
        return event_attendee_last_name;
    }
    public void setEvent_attendee_last_name(String event_attendee_last_name) {
        this.event_attendee_last_name = event_attendee_last_name;
    }

}
