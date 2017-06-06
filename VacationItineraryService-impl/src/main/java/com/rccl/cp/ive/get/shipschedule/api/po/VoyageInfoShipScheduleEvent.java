package com.rccl.cp.ive.get.shipschedule.api.po;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "guest_calendar",
    name = "shipsailinfo_by_shipcode_and_saildate_v1",
    readConsistency = "QUORUM",
    writeConsistency = "QUORUM",
    caseSensitiveKeyspace = false,
    caseSensitiveTable = false)
public class VoyageInfoShipScheduleEvent {
    @PartitionKey(0)
    private String ship_code;
    @PartitionKey(1)
    private String sail_date;
    @ClusteringColumn
    private int day_of_voyage;
    private String arrival_datetime;
    private String departure_datetime;
    private String event_type;
    private String itinerary_code;
    private String port_code;
    private String port_name;
    private String voyage_description;

    public String getShip_code() {
        return ship_code;
    }
    public void setShip_code(String ship_code) {
        this.ship_code = ship_code;
    }
    public String getSail_date() {
        return sail_date;
    }
    public void setSail_date(String sail_date) {
        this.sail_date = sail_date;
    }
    public int getDay_of_voyage() {
        return day_of_voyage;
    }
    public void setDay_of_voyage(int day_of_voyage) {
        this.day_of_voyage = day_of_voyage;
    }
    public String getArrival_datetime() {
        return arrival_datetime;
    }
    public void setArrival_datetime(String arrival_datetime) {
        this.arrival_datetime = arrival_datetime;
    }
    public String getDeparture_datetime() {
        return departure_datetime;
    }
    public void setDeparture_datetime(String departure_datetime) {
        this.departure_datetime = departure_datetime;
    }
    public String getEvent_type() {
        return event_type;
    }
    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
    public String getItinerary_code() {
        return itinerary_code;
    }
    public void setItinerary_code(String itinerary_code) {
        this.itinerary_code = itinerary_code;
    }
    public String getPort_code() {
        return port_code;
    }
    public void setPort_code(String port_code) {
        this.port_code = port_code;
    }
    public String getPort_name() {
        return port_name;
    }
    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }
    public String getVoyage_description() {
        return voyage_description;
    }
    public void setVoyage_description(String voyage_description) {
        this.voyage_description = voyage_description;
    }
}
