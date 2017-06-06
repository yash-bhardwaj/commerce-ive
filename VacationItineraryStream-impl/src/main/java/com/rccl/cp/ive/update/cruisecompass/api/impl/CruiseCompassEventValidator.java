package com.rccl.cp.ive.update.cruisecompass.api.impl;

import com.rccl.cp.ive.update.cruisecompass.api.impl.CruiseCompassEventCommand.UpdateCruiseCompassEventCommand;

public final class CruiseCompassEventValidator {
    private CruiseCompassEventValidator() {
    }

    public static boolean isValidUpdateCommand(
        final UpdateCruiseCompassEventCommand cmd) {
        return true;
    }
}
