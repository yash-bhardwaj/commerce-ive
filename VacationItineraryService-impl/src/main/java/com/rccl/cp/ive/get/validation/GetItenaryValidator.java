package com.rccl.cp.ive.get.validation;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lightbend.lagom.javadsl.api.transport.BadRequest;

public final class GetItenaryValidator {

	private static final int maxLengthGuestId = 9;

	private GetItenaryValidator() {
	}

	public static String validateRequest(final String shipSailDate, final String cruiseBookingID, final String guestID) {
		System.out.println("validating GetMyItenary Request params [" + shipSailDate + "] cbID [" + cruiseBookingID
				+ "] guestId [" + guestID + "]");

		String errors = "";
		if (!(Pattern.compile("^[A-Z0-9]+$").matcher(shipSailDate).matches())) {
			errors = errors.concat(shipSailDate + " is an invalid ship sail date in URL. ");
		}
		if (!isNumberIdValid(cruiseBookingID)) {
			errors = errors.concat(cruiseBookingID + " is an invalid cruise booking ID. ");
		}

		if (!isNumberIdValid(guestID) || guestID.length() > maxLengthGuestId) {
			errors = errors.concat(guestID + " is an invalid guest ID. ");
		}

		return errors;
	}

	static boolean isNumberIdValid(final String id) {
		return Pattern.compile("^[0-9]+$").matcher(id).matches();
	}
}
