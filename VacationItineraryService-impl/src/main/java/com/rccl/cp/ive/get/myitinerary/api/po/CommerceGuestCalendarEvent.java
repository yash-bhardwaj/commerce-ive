package com.rccl.cp.ive.get.myitinerary.api.po;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.datastax.driver.mapping.annotations.Transient;
import com.rccl.cp.ive.get.myitinerary.api.EventAttendee;

@Table(keyspace = "guest_calendar", name = "calendar_events_by_guest",
    readConsistency = "QUORUM",
    writeConsistency = "QUORUM",
    caseSensitiveKeyspace = false,
    caseSensitiveTable = false)
public class CommerceGuestCalendarEvent {

    @PartitionKey(0)
    private String sailing_id;
    @PartitionKey(1)
    private String guest_id;
    @ClusteringColumn(0)
    private String source_system_reservation_id;
    @ClusteringColumn(1)
    private String source_system_application_id;
    @ClusteringColumn(2)
    private String source_system_offering_id;
    private String cruise_reservation_id;
    private String first_name;
    private String last_name;
    private String event_group_type;
    private String event_group_description;
    private String event_type;
    private String event_name;
    private String event_locale;
    private String event_location_code;
    private String event_location_type;
    private String event_location_name;
    private LocalTime event_start_time;
    private LocalDate event_start_date;
    private String event_start_time_zone;
    private LocalTime event_end_time;
    private LocalDate event_end_date;
    private String event_end_time_zone;
    private String source_system_order_id;
    private String source_system_external_order_id;
    private String source_system_product_id;
    private String source_system_product_name;
    private String event_owner_reservation_id;
    private String event_owner_guest_id;
    @Transient
    private List<EventAttendee> attendees;

    public String getSailing_id() {
        return sailing_id;
    }
    public void setSailing_id(String sailing_id) {
        this.sailing_id = sailing_id;
    }
    public String getGuest_id() {
        return guest_id;
    }
    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
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
    public String getCruise_reservation_id() {
        return cruise_reservation_id;
    }
    public void setCruise_reservation_id(String cruise_reservation_id) {
        this.cruise_reservation_id = cruise_reservation_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEvent_group_type() {
        return event_group_type;
    }
    public void setEvent_group_type(String event_group_type) {
        this.event_group_type = event_group_type;
    }
    public String getEvent_group_description() {
        return event_group_description;
    }
    public void setEvent_group_description(String event_group_description) {
        this.event_group_description = event_group_description;
    }
    public String getEvent_type() {
        return event_type;
    }
    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
    public String getEvent_name() {
        return event_name;
    }
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
    public String getEvent_locale() {
        return event_locale;
    }
    public void setEvent_locale(String event_locale) {
        this.event_locale = event_locale;
    }
    public String getEvent_location_code() {
        return event_location_code;
    }
    public void setEvent_location_code(String event_location_code) {
        this.event_location_code = event_location_code;
    }
    public String getEvent_location_type() {
        return event_location_type;
    }
    public void setEvent_location_type(String event_location_type) {
        this.event_location_type = event_location_type;
    }
    public String getEvent_location_name() {
        return event_location_name;
    }
    public void setEvent_location_name(String event_location_name) {
        this.event_location_name = event_location_name;
    }
    public LocalTime getEvent_start_time() {
        return event_start_time;
    }
    public void setEvent_start_time(LocalTime event_start_time) {
        this.event_start_time = event_start_time;
    }
    public LocalDate getEvent_start_date() {
        return event_start_date;
    }
    public void setEvent_start_date(LocalDate event_start_date) {
        this.event_start_date = event_start_date;
    }
    public String getEvent_start_time_zone() {
        return event_start_time_zone;
    }
    public void setEvent_start_time_zone(String event_start_time_zone) {
        this.event_start_time_zone = event_start_time_zone;
    }
    public LocalTime getEvent_end_time() {
        return event_end_time;
    }
    public void setEvent_end_time(LocalTime event_end_time) {
        this.event_end_time = event_end_time;
    }
    public LocalDate getEvent_end_date() {
        return event_end_date;
    }
    public void setEvent_end_date(LocalDate event_end_date) {
        this.event_end_date = event_end_date;
    }
    public String getEvent_end_time_zone() {
        return event_end_time_zone;
    }
    public void setEvent_end_time_zone(String event_end_time_zone) {
        this.event_end_time_zone = event_end_time_zone;
    }
    public String getSource_system_reservation_id() {
        return source_system_reservation_id;
    }
    public void setSource_system_reservation_id(String source_system_reservation_id) {
        this.source_system_reservation_id = source_system_reservation_id;
    }
    public String getSource_system_order_id() {
        return source_system_order_id;
    }
    public void setSource_system_order_id(String source_system_order_id) {
        this.source_system_order_id = source_system_order_id;
    }
    public String getSource_system_external_order_id() {
        return source_system_external_order_id;
    }
    public void setSource_system_external_order_id(String source_system_external_order_id) {
        this.source_system_external_order_id = source_system_external_order_id;
    }
    public String getSource_system_product_id() {
        return source_system_product_id;
    }
    public void setSource_system_product_id(String source_system_product_id) {
        this.source_system_product_id = source_system_product_id;
    }
    public String getSource_system_product_name() {
        return source_system_product_name;
    }
    public void setSource_system_product_name(String source_system_product_name) {
        this.source_system_product_name = source_system_product_name;
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
    public List<EventAttendee> getAttendees() {
        return attendees;
    }
    public void setAttendees(List<EventAttendee> attendees) {
        this.attendees = attendees;
    }
    // @Override
    // public String toString() {
    // return "CommerceGuestCalendarEvent [sailing_id=" + sailing_id + ",
    // guest_id=" + guest_id
    // + ", source_system_application_id=" + source_system_application_id + ",
    // source_system_offering_id="
    // + source_system_offering_id + ", cruise_reservation_id=" +
    // cruise_reservation_id + ", first_name="
    // + first_name + ", last_name=" + last_name + ", event_group_type=" +
    // event_group_type
    // + ", event_group_description=" + event_group_description + ",
    // event_type=" + event_type + ", event_id="
    // + event_id + ", event_name=" + event_name + ", event_locale=" +
    // event_locale + ", event_location_code="
    // + event_location_code + ", event_location_type=" + event_location_type +
    // ", event_location_name="
    // + event_location_name + ", event_start_time=" + event_start_time + ",
    // event_start_date="
    // + event_start_date + ", event_start_time_zone=" + event_start_time_zone +
    // ", event_end_time="
    // + event_end_time + ", event_end_date=" + event_end_date + ",
    // event_end_time_zone=" + event_end_time_zone
    // + ", source_system_reservation_id=" + source_system_reservation_id + ",
    // source_system_order_id="
    // + source_system_order_id + ", source_system_external_order_id=" +
    // source_system_external_order_id
    // + ", source_system_product_id=" + source_system_product_id + ",
    // source_system_product_name="
    // + source_system_product_name + ", event_owner_reservation_id="
    // + event_owner_reservation_id + ", event_owner_guest_id=" +
    // event_owner_guest_id + ", attendees="
    // + attendees + "]";
    // }
}
