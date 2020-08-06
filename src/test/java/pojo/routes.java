package pojo;

import java.util.List;

public class routes {
    private float bufferTime;
    private String drop_stop_title;
    public FromLoc fromLoc;
    public List<futureSlots> futureSlots;
    private boolean isActive;
    private boolean isNotificationEnabled;
    private float journeyTime;
    private String journeyTimeText;
    private String moreShuttlsInfoMessage;
    private boolean multiScreen;
    private String offTimeMessage;
    private String offTimeRouteId;
    private String operating_window;
    public PassRideInfo passRideInfo;
    private String pickup_stop_title;
    private float reminderBeforeTime;
    private String reminderMessage;
    private String reminderNotificationMessage;
    private String reminderTitle;
    private String routeId;
    private String slot_count_text;
    public List<slots> slots;
    private String timeSlotPairMessageType;
    public ToLoc toLoc;
    private String unbookMessage;
    private String unbookTitle;
    public List <unbookableSlots> unbookableSlots;

    public String getDrop_stop_title() {
        return drop_stop_title;
    }

    public void setDrop_stop_title(String drop_stop_title) {
        this.drop_stop_title = drop_stop_title;
    }


    public List<pojo.futureSlots> getFutureSlots() {
        return futureSlots;
    }

    public void setFutureSlots(List<pojo.futureSlots> futureSlots) {
        this.futureSlots = futureSlots;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void SetIsActive(boolean active) {
        isActive = active;
    }

    public boolean getIsNotificationEnabled() {
        return isNotificationEnabled;
    }

    public void setIsNotificationEnabled(boolean notificationEnabled) {
        isNotificationEnabled = notificationEnabled;
    }

    public float getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(float journeyTime) {
        this.journeyTime = journeyTime;
    }

    public String getJourneyTimeText() {
        return journeyTimeText;
    }

    public void setJourneyTimeText(String journeyTimeText) {
        this.journeyTimeText = journeyTimeText;
    }

    public String getMoreShuttlsInfoMessage() {
        return moreShuttlsInfoMessage;
    }

    public void setMoreShuttlsInfoMessage(String moreShuttlsInfoMessage) {
        this.moreShuttlsInfoMessage = moreShuttlsInfoMessage;
    }

    public boolean getMultiScreen() {
        return multiScreen;
    }

    public void setMultiScreen(boolean multiScreen) {
        this.multiScreen = multiScreen;
    }

    public String getOffTimeMessage() {
        return offTimeMessage;
    }

    public void setOffTimeMessage(String offTimeMessage) {
        this.offTimeMessage = offTimeMessage;
    }

    public String getOffTimeRouteId() {
        return offTimeRouteId;
    }

    public void setOffTimeRouteId(String offTimeRouteId) {
        this.offTimeRouteId = offTimeRouteId;
    }

    public String getOperating_window() {
        return operating_window;
    }

    public void setOperating_window(String operating_window) {
        this.operating_window = operating_window;
    }

    public PassRideInfo getPassRideInfo() {
        return passRideInfo;
    }

    public void setPassRideInfo(PassRideInfo passRideInfo) {
        this.passRideInfo = passRideInfo;
    }

    public String getPickup_stop_title() {
        return pickup_stop_title;
    }

    public void setPickup_stop_title(String pickup_stop_title) {
        this.pickup_stop_title = pickup_stop_title;
    }

    public float getReminderBeforeTime() {
        return reminderBeforeTime;
    }

    public void setReminderBeforeTime(float reminderBeforeTime) {
        this.reminderBeforeTime = reminderBeforeTime;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }

    public void setReminderMessage(String reminderMessage) {
        this.reminderMessage = reminderMessage;
    }

    public String getReminderNotificationMessage() {
        return reminderNotificationMessage;
    }

    public void setReminderNotificationMessage(String reminderNotificationMessage) {
        this.reminderNotificationMessage = reminderNotificationMessage;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getSlot_count_text() {
        return slot_count_text;
    }

    public void setSlot_count_text(String slot_count_text) {
        this.slot_count_text = slot_count_text;
    }

    public List<pojo.slots> getSlots() {
        return slots;
    }

    public void setSlots(List<pojo.slots> slots) {
        this.slots = slots;
    }

    public String getTimeSlotPairMessageType() {
        return timeSlotPairMessageType;
    }

    public void setTimeSlotPairMessageType(String timeSlotPairMessageType) {
        this.timeSlotPairMessageType = timeSlotPairMessageType;
    }

    public ToLoc getToLoc() {
        return toLoc;
    }

    public void setToLoc(ToLoc toLoc) {
        this.toLoc = toLoc;
    }

    public String getUnbookMessage() {
        return unbookMessage;
    }

    public void setUnbookMessage(String unbookMessage) {
        this.unbookMessage = unbookMessage;
    }

    public String getUnbookTitle() {
        return unbookTitle;
    }

    public void setUnbookTitle(String unbookTitle) {
        this.unbookTitle = unbookTitle;
    }

    public List<pojo.unbookableSlots> getUnbookableSlots() {
        return unbookableSlots;
    }

    public void setUnbookableSlots(List<pojo.unbookableSlots> unbookableSlots) {
        this.unbookableSlots = unbookableSlots;
    }
    public float getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(float bufferTime) {
        this.bufferTime = bufferTime;
    }
    public FromLoc getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(FromLoc fromLoc) {
        this.fromLoc = fromLoc;
    }

}
