package pojo;

import java.util.List;

public class RescheduleSlotsDataRoutesSlots {

    public RescheduleSlotsDataRoutesSlotsCoupon coupon;
    public RescheduleSlotsDataRoutesSlotsCta cta;
    private boolean isCurrentRide;
    private String nonOpMessage;
    private boolean operational;
    private String slotCategory;
    public List< RescheduleSlotsDataRoutesSlotsSlotTags > slotTags;
    private String slotText;
    private String slotType;
    private String startTime;
    public RescheduleSlotsDataRoutesSlotsTrip trip;
    private boolean useInactiveCta;

    public RescheduleSlotsDataRoutesSlotsCoupon getCoupon() {
        return coupon;
    }

    public RescheduleSlotsDataRoutesSlotsCta getCta() {
        return cta;
    }

    public boolean getIsCurrentRide() {
        return isCurrentRide;
    }

    public String getNonOpMessage() {
        return nonOpMessage;
    }

    public boolean getOperational() {
        return operational;
    }

    public String getSlotCategory() {
        return slotCategory;
    }

    public List<RescheduleSlotsDataRoutesSlotsSlotTags> getSlotTags() {
        return slotTags;
    }

    public String getSlotText() {
        return slotText;
    }

    public String getSlotType() {
        return slotType;
    }

    public String getStartTime() {
        return startTime;
    }

    public RescheduleSlotsDataRoutesSlotsTrip getTrip() {
        return trip;
    }

    public boolean getUseInactiveCta() {
        return useInactiveCta;
    }
}
