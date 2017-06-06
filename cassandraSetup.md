CREATE KEYSPACE if not exists guest_calendar
WITH REPLICATION = {
  'class': 'SimpleStrategy',
  'replication_factor' : 1
};


drop table if exists guest_calendar.calendar_events_by_guest;
create table guest_calendar.calendar_events_by_guest (
sailing_id text,
guest_id text,
source_system_reservation_id text,
source_system_application_id text,
source_system_offering_id text,
cruise_reservation_id  text,
first_name text static,
last_name text static,
event_group_type text,
event_group_description text,
event_type text,
event_id uuid,
event_name text,
event_locale text,
event_location_code text,
event_location_type text,
event_location_name text,
event_start_date date,
event_start_time time,
event_start_time_zone text,
event_end_date date,
event_end_time time,
event_end_time_zone text,
source_system_order_id text,
source_system_external_order_id text,
source_system_product_id text,
source_system_product_name text,
event_owner_reservation_id text,
event_owner_guest_id text,
primary key ((sailing_id, guest_id), source_system_reservation_id, source_system_application_id, source_system_offering_id)
);


drop table if exists guest_calendar.event_attendees_by_owner;
create table guest_calendar.event_attendees_by_owner (
sailing_id text,
event_owner_reservation_id text,
event_owner_guest_id text,
source_system_application_id text,
source_system_offering_id text,
event_attendee_guest_id text,
event_attendee_cruise_reservation_id text,
event_attendee_first_name text,
event_attendee_last_name text,
primary key ((sailing_id, event_owner_reservation_id), event_owner_guest_id, source_system_application_id, source_system_offering_id, event_attendee_guest_id)
);


DROP TABLE IF EXISTS guest_calendar.shipsailinfo_by_shipcode_and_saildate_v1;
CREATE TABLE guest_calendar.shipsailinfo_by_shipcode_and_saildate_v1 (
	ship_code text,
	sail_date text,
	day_of_voyage int,
	arrival_datetime text,
	departure_datetime text,
	event_type text,
	itinerary_code text,
	port_code text,
	port_name text,
	voyage_description text,
	PRIMARY KEY (( ship_code, sail_date ), day_of_voyage)
) WITH bloom_filter_fp_chance = 0.01
AND comment = ''
AND crc_check_chance = 1.0
AND dclocal_read_repair_chance = 0.1
AND default_time_to_live = 0
AND gc_grace_seconds = 864000
AND max_index_interval = 2048
AND memtable_flush_period_in_ms = 0
AND min_index_interval = 128
AND read_repair_chance = 0.0
AND speculative_retry = '99.0PERCENTILE'
AND caching = {
	'keys' : 'ALL',
	'rows_per_partition' : 'NONE'
}
AND compression = {
	'chunk_length_in_kb' : 64,
	'class' : 'LZ4Compressor',
	'enabled' : true
}
AND compaction = {
	'class' : 'SizeTieredCompactionStrategy',
	'max_threshold' : 32,
	'min_threshold' : 4
};
