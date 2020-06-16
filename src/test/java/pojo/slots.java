package pojo;

import java.util.List;

public class slots {

    private Coupon coupon;
    private Cta cta;
    private boolean isCurrentRide;
    private String nonOpMessage;
    private boolean operational;
    private String slotCategory;
    private String slotType;
    private float startTime;
    private Trip trip;
    private boolean useInactiveCta;
    private String slotText;

    public List<pojo.slotTags> getSlotTags() {
        return slotTags;
    }

    public void setSlotTags(List<pojo.slotTags> slotTags) {
        this.slotTags = slotTags;
    }

    public List<slotTags> slotTags;


    public String getSlotText() {
        return slotText;
    }

    public void setSlotText(String slotText) {
        this.slotText = slotText;
    }


    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Cta getCta() {
        return cta;
    }

    public void setCta(Cta cta) {
        this.cta = cta;
    }

    public boolean getIsCurrentRide() {
        return isCurrentRide;
    }

    public void setIsCurrentRide(boolean currentRide) {
        isCurrentRide = currentRide;
    }

    public String getNonOpMessage() {
        return nonOpMessage;
    }

    public void setNonOpMessage(String nonOpMessage) {
        this.nonOpMessage = nonOpMessage;
    }

    public boolean isOperational() {
        return operational;
    }

    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    public String getSlotCategory() {
        return slotCategory;
    }

    public void setSlotCategory(String slotCategory) {
        this.slotCategory = slotCategory;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public boolean getUseInactiveCta() {
        return useInactiveCta;
    }

    public void setUseInactiveCta(boolean useInactiveCta) {
        this.useInactiveCta = useInactiveCta;
    }


}
