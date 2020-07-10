package pojo;

import java.util.List;

public class RescheduleSlotsDataRoutes {
    private float bufferTime;
    private String drop_stop_title;
    public RescheduleSlotsDataRoutesFromLoc fromLoc;
    public List<RescheduleSlotsDataRoutesFutureSlots> futureSlots;
    private boolean isActive;
    private boolean isNotificationEnabled;
    private float journeyTime;
    private String journeyTimeText;
    private String moreShuttlsInfoMessage;
    private boolean multiScreen;
    private String offTimeMessage;
    private String offTimeRouteId;
    private String operating_window;
    private String pickup_stop_title;
    private float reminderBeforeTime;
    private String reminderMessage;
    private String reminderNotificationMessage;
    private String reminderTitle;
    private String routeId;
    private String slot_count_text;
    public List<RescheduleSlotsDataRoutesSlots> slots;
    private String timeSlotPairMessageType;
    public RescheduleSlotsDataRoutesToLoc toLoc;
    private String unbookMessage;
    private String unbookTitle;
    public List < RescheduleSlotsDataRoutesUnbookableSlots > unbookableSlots;

    public float getBufferTime() {
        return bufferTime;
    }

    public String getDrop_stop_title() {
        return drop_stop_title;
    }

    public RescheduleSlotsDataRoutesFromLoc getFromLoc() {
        return fromLoc;
    }

    public List<RescheduleSlotsDataRoutesFutureSlots> getFutureSlots() {
        return futureSlots;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsNotificationEnabled() {
        return isNotificationEnabled;
    }

    public float getJourneyTime() {
        return journeyTime;
    }

    public String getJourneyTimeText() {
        return journeyTimeText;
    }

    public String getMoreShuttlsInfoMessage() {
        return moreShuttlsInfoMessage;
    }

    public boolean getMultiScreen() {
        return multiScreen;
    }

    public String getOffTimeMessage() {
        return offTimeMessage;
    }

    public String getOffTimeRouteId() {
        return offTimeRouteId;
    }

    public String getOperating_window() {
        return operating_window;
    }

    public String getPickup_stop_title() {
        return pickup_stop_title;
    }

    public float getReminderBeforeTime() {
        return reminderBeforeTime;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }

    public String getReminderNotificationMessage() {
        return reminderNotificationMessage;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getSlot_count_text() {
        return slot_count_text;
    }

    public List<RescheduleSlotsDataRoutesSlots> getSlots() {
        return slots;
    }

    public String getTimeSlotPairMessageType() {
        return timeSlotPairMessageType;
    }

    public RescheduleSlotsDataRoutesToLoc getToLoc() {
        return toLoc;
    }

    public String getUnbookMessage() {
        return unbookMessage;
    }

    public String getUnbookTitle() {
        return unbookTitle;
    }

    public List<RescheduleSlotsDataRoutesUnbookableSlots> getUnbookableSlots() {
        return unbookableSlots;
    }
}
