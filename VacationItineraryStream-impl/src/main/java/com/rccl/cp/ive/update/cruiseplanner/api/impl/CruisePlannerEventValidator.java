package com.rccl.cp.ive.update.cruiseplanner.api.impl;

import com.rccl.cp.ive.update.cruiseplanner.api.impl.CruisePlannerEventCommand.UpdateCruisePlannerEventCommand;

public final class CruisePlannerEventValidator {
    private CruisePlannerEventValidator() {
    }

    public static boolean isValidUpdateCommand(
        final UpdateCruisePlannerEventCommand cmd) {
        return true;
    }
}
