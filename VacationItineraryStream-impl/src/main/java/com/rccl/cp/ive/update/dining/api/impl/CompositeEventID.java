package com.rccl.cp.ive.update.dining.api.impl;

public class CompositeEventID {
    // shipSailDate/guestId/sourceSystemApplicationId/sourceSystemOfferingId

    private final String shipSailDate;
    private final String guestID;
    private final String sourceSystemApplicationID;
    private final String sourceSystemOfferingID;
    private static final int HASH_PRIME = 31;

    public CompositeEventID(final String shipSailDt, final String gustId,
        final String srcSystemApplicationID,
        final String srcSystemOfferingID) {
        this.shipSailDate = shipSailDt;
        this.guestID = gustId;
        this.sourceSystemApplicationID = srcSystemApplicationID;
        this.sourceSystemOfferingID = srcSystemOfferingID;
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
        int systemApplicationID = 0;
        if (sourceSystemApplicationID != null) {
            systemApplicationID = sourceSystemApplicationID.hashCode();
        }
        int systemOfferingID = 0;
        if (sourceSystemOfferingID != null) {
            systemOfferingID = sourceSystemOfferingID.hashCode();
        }
        int guestId = 0;
        if (guestID != null) {
            guestId = guestID.hashCode();
        }
        int sailDate = 0;
        if (shipSailDate != null) {
            sailDate = shipSailDate.hashCode();
        }
        result = prime * result + systemApplicationID;
        result = prime * result + systemOfferingID;
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
