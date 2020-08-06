package pojo;

public class RescheduleSlotsDataRoutesSlotsTrip {
    private float fare;
    private String id;
    private boolean isEtaStatic;
    private float journeyTime;
    private String offer = null;
    private String routeId;
    private float seatsAvailable;
    private boolean selected;
    private String startMessage;
    private float startTime;
    private float staticTime;
    public Status status;
    private String statusText;
    private float time;

    public float getFare() {
        return fare;
    }

    public String getId() {
        return id;
    }

    public boolean getIsEtaStatic() {
        return isEtaStatic;
    }

    public float getJourneyTime() {
        return journeyTime;
    }

    public String getOffer() {
        return offer;
    }

    public String getRouteId() {
        return routeId;
    }

    public float getSeatsAvailable() {
        return seatsAvailable;
    }

    public boolean getSelected() {
        return selected;
    }

    public String getStartMessage() {
        return startMessage;
    }

    public float getStartTime() {
        return startTime;
    }

    public float getStaticTime() {
        return staticTime;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public float getTime() {
        return time;
    }
}
