package com.rccl.cp.ive.update.validation;

import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;

public final class DeleteRequestValidator {

    private DeleteRequestValidator() {
    }

    public static void validateRequest(final String shipSailDate,
        final String guestID,
        final String ownerGuestID,
        final String sourceSystemApplicationID,
        final String sourcesystemOfferingID) {

        String errors = "";

        if (!UpdateRequestValidator.isShipSailDateValid(shipSailDate)) {
            errors = errors.concat(shipSailDate
                + " is an invalid ship sail date. ");
        }

        if (!UpdateRequestValidator.isNumberIdValid(guestID)) {
            errors = errors.concat(guestID
                + " is an invalid guest ID. ");
        }

        if (!UpdateRequestValidator.isNumberIdValid(ownerGuestID)) {
            errors = errors.concat(guestID
                + " is an invalid owner guest ID. ");
        }

        if (!UpdateRequestValidator.isSourceSystemApplicationIDValid(sourceSystemApplicationID)) {
            errors = errors.concat(sourceSystemApplicationID
                + " is an invalid source system application ID. ");
        }

        if (!UpdateRequestValidator.isSourceSystemOfferingIDValid(sourcesystemOfferingID)) {
            errors = errors.concat(sourcesystemOfferingID
                + " is an invalid source system offering ID. ");
        }

        if (!errors.isEmpty()) {
            throw new BadRequest(errors);
        }

    }

    public static void validateDbTable(CassandraSession sess) {
        UpdateRequestValidator.validateDbTable(sess);
    }
}
