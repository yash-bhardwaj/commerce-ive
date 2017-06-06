package com.rccl.cp.ive.update.readside.po;

import java.util.List;

import com.rccl.cp.ive.update.common.BasicMessage;
import com.rccl.cp.ive.update.common.EventAttendee;

public class AttendeeUpdateMessage {

    private BasicMessage message;
    private List<EventAttendee> attendees;

    public AttendeeUpdateMessage(final BasicMessage msg,
        final List<EventAttendee> attends) {
        super();
        this.message = msg;
        this.attendees = attends;
    }

    public final BasicMessage getMessage() {
        return message;
    }

    public final List<EventAttendee> getAttendees() {
        return attendees;
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AttendeeUpdateMessage [message=");
        builder.append(message);
        builder.append(", attendee=");
        builder.append(attendees);
        builder.append("]");
        return builder.toString();
    }
}
