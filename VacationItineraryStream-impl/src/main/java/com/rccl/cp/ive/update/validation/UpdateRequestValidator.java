package com.rccl.cp.ive.update.validation;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.lightbend.lagom.javadsl.api.deser.ExceptionMessage;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.TransportErrorCode;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;
import com.rccl.cp.ive.update.common.EventSourceDetail;

public final class UpdateRequestValidator {

    private static Logger logger = LoggerFactory.getLogger(UpdateRequestValidator.class);

    private UpdateRequestValidator() {
    }

    public static void validateRequest(final BasicMessage message, String shipSailDate) {
        String errors = "";
        if (!isNumberIdValid(message.cruiseBookingID())) {
            errors = errors.concat(message.cruiseBookingID()
                + " is an invalid cruise booking ID. ");
        }

        if (!isNumberIdValid(message.guestID())) {
            errors = errors.concat(message.guestID()
                + " is an invalid guest ID. ");
        }

        if (!message.eventStartTime().eventDate()
            .matches("\\d{4}-\\d{2}-\\d{2}")) {
            errors = errors.concat(message.eventStartTime().eventDate()
                + " is an invalid event start date. ");
        }

        if (!message.eventEndTime().eventDate()
            .matches("\\d{4}-\\d{2}-\\d{2}")) {
            errors = errors.concat(message.eventEndTime().eventDate()
                + " is an invalid event end date. ");
        }

        if (!message.eventStartTime().eventTime().matches("\\d{2}:\\d{2}")) {
            errors = errors.concat(message.eventStartTime().eventTime()
                + " is an invalid event start time. ");
        }

        if (!message.eventEndTime().eventTime().matches("\\d{2}:\\d{2}")) {
            errors = errors.concat(message.eventEndTime().eventTime()
                + " is an invalid event end time. ");
        }

        if (!(isShipSailDateValid(shipSailDate))) {
            errors = errors.concat(shipSailDate
                + " is an invalid ship sail date in URL. ");
        }

        if (!(isShipSailDateValid(message.shipSailDate()))) {
            errors = errors.concat(message.shipSailDate()
                + " is an invalid ship sail date. ");
        } else if (!message.shipSailDate().equals(shipSailDate)) {
            errors = errors.concat("shipSailDate pass in URL and shipSailDate pass in JSON body must be same.");
        }

        if (!isEventGroupDescriptionValid(message.eventGroupDescription())) {
            errors = errors.concat(message.eventGroupDescription()
                + " is an invalid event group description. ");
        }

        if (!isEventGroupTypeValid(message.eventGroupType())) {
            errors = errors.concat(message.eventGroupType()
                + " is an invalid event group type. ");
        }

        if (!isEventTypeValid(message.eventType())) {
            errors = errors.concat(message.eventType()
                + " is an invalid event type. ");
        }

        EventSourceDetail sourceDetail = message.sourceDetail();
        if (sourceDetail != null) {

            if (!isSourceSystemApplicationIDValid(sourceDetail.sourceSystemApplicationID())) {
                errors = errors.concat(sourceDetail.sourceSystemApplicationID()
                    + " is an invalid source system application ID. ");
            }

            if (!isSourceSystemOfferingIDValid(sourceDetail.sourceSystemOfferingID())) {
                errors = errors.concat(sourceDetail.sourceSystemOfferingID()
                    + " is an invalid source system offering ID. ");
            }

        } else {
            errors = errors.concat(" sourceDetail has invalid value.");
        }

        for (Iterator<EventAttendee> iter = message.attendees().get()
            .iterator(); iter.hasNext();) {
            EventAttendee attendee = iter.next();
            if (!isNumberIdValid(attendee.cruiseReservationID())) {
                errors = errors.concat(attendee.cruiseReservationID()
                    + " is an invalid cruise booking ID. ");
            }

            if (!isNumberIdValid(attendee.guestID())) {
                errors = errors.concat(attendee.guestID()
                    + " is an invalid guest ID. ");
            }
        }

        if (!errors.isEmpty()) {
            throw new BadRequest(errors);
        }
    }

    static boolean isNumberIdValid(final String id) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    static boolean isShipSailDateValid(String shipSailDate) {

        // check for uppercase letters and numbers
        Pattern pattern = Pattern.compile("^[A-Z0-9]+$");
        Matcher matcher = pattern.matcher(shipSailDate);
        return matcher.matches();
    }

    private static boolean isEventGroupTypeValid(String eventGroupType) {

        // check for uppercase letters
        Pattern pattern = Pattern.compile("^[A-Z]+$");
        Matcher matcher = pattern.matcher(eventGroupType);
        return matcher.matches();
    }

    private static boolean isEventGroupDescriptionValid(String eventGroupDescription) {

        // check for sentence without any special char
        Pattern pattern = Pattern.compile("^[A-Za-z0-9 ]+$");
        Matcher matcher = pattern.matcher(eventGroupDescription);
        return matcher.matches();
    }

    private static boolean isEventTypeValid(String eventType) {

        // check for uppercase letters
        Pattern pattern = Pattern.compile("^[A-Z_]+$");
        Matcher matcher = pattern.matcher(eventType);
        return matcher.matches();
    }

    private static boolean isEventLocaleValid(String eventLocale) {
        return StringUtils.isEmpty(eventLocale);
    }

    static boolean isSourceSystemApplicationIDValid(String sourceSystemApplicationID) {

        Pattern pattern = Pattern.compile("^[A-Z]+$");
        Matcher matcher = pattern.matcher(sourceSystemApplicationID);
        return matcher.matches();
    }

    static boolean isSourceSystemOfferingIDValid(String sourceSystemOfferingID) {

        Pattern pattern = Pattern.compile("^[A-Za-z0-9-]+?$");
        Matcher matcher = pattern.matcher(sourceSystemOfferingID);
        return matcher.matches();
    }

    public static void validateDbTable(CassandraSession sess) {
        try {
            Session session = sess.underlying().toCompletableFuture().get();
            ResultSet resultSet =
                session.execute("SELECT * FROM system_schema.keyspaces where keyspace_name='guest_calendar'");

            if (resultSet.all().size() == 0) {
                logger.error("guest_calendar keyspace not exist in cassandra");
                throw new BadRequest(TransportErrorCode.InternalServerError,
                    new ExceptionMessage("error", "internal server error"));
            }

        } catch (InterruptedException e) {
            logger.error("InterruptedException in validateDbTable", e);
            throw new BadRequest(TransportErrorCode.InternalServerError,
                new ExceptionMessage("error", "internal server error"));
        } catch (ExecutionException e) {
            logger.error("ExecutionException in validateDbTable", e);
            throw new BadRequest(TransportErrorCode.InternalServerError,
                new ExceptionMessage("error", "internal server error"));
        }
    }
}
