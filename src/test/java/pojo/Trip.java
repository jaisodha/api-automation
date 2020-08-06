package pojo;

public class Trip {
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
    public Status StatusObject;
    private String statusText;
    private float time;


    // Getter Methods

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
        return StatusObject;
    }

    public String getStatusText() {
        return statusText;
    }

    public float getTime() {
        return time;
    }

    // Setter Methods

    public void setFare(float fare) {
        this.fare = fare;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsEtaStatic(boolean isEtaStatic) {
        this.isEtaStatic = isEtaStatic;
    }

    public void setJourneyTime(float journeyTime) {
        this.journeyTime = journeyTime;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setSeatsAvailable(float seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public void setStaticTime(float staticTime) {
        this.staticTime = staticTime;
    }

    public void setStatus(Status statusObject) {
        this.StatusObject = statusObject;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setTime(float time) {
        this.time = time;
    }
}