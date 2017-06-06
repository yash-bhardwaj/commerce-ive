package com.rccl.cp.ive.update.cruisecompass.api.impl;

public class CompositeEventID {
    // shipSailDate/guestId/sourceSystemApplicationId/sourceSystemOfferingId

    private final String shipSailDate;
    private final String guestID;
    private final String sourceSystemApplicationID;
    private final String sourceSystemOfferingID;
    private static final int HASH_PRIME = 31;

    public CompositeEventID(final String sailDate, final String guestId,
        final String systemApplicationId,
        final String systemOfferingId) {
        this.shipSailDate = sailDate;
        this.guestID = guestId;
        this.sourceSystemApplicationID = systemApplicationId;
        this.sourceSystemOfferingID = systemOfferingId;
    }

    @Override
    public final boolean equals(final Object aThat) {
        if (this == aThat) {
            return true;
        }

        if (!(aThat instanceof CompositeEventID)) {
            return false;
        }

        CompositeEventID that = (CompositeEventID) aThat;

        return this.shipSailDate == that.shipSailDate
            && this.guestID == that.guestID
            && this.sourceSystemApplicationID == that.sourceSystemApplicationID
            && this.sourceSystemOfferingID == that.sourceSystemOfferingID;
    }

    @Override
    public final int hashCode() {
        int prime = HASH_PRIME;
        int result = 1;
        int sourceAppId = 0;
        int sourceOfferingId = 0;
        int guestId = 0;
        if (guestID != null) {
            guestId = guestID.hashCode();
        }
        int sailDate = 0;
        if (shipSailDate != null) {
            sailDate = shipSailDate.hashCode();
        }
        if (sourceSystemApplicationID != null) {
            sourceAppId = sourceSystemApplicationID.hashCode();
        }
        if (sourceSystemOfferingID != null) {
            sourceOfferingId = sourceSystemOfferingID.hashCode();
        }
        result = prime * result + sourceAppId;
        result = prime * result + sourceOfferingId;
        result = prime * result + guestId;
        result = prime * result + sailDate;
        return result;
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        builder.append(shipSailDate);
        builder.append("/");
        builder.append(guestID);
        builder.append("/");
        builder.append(sourceSystemApplicationID);
        builder.append("/");
        builder.append(sourceSystemOfferingID);
        return builder.toString();
    }

}
