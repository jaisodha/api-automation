package pojo;

public class PassOd {

    public PassFromStop from_stop;
    private String title;
    public PassToStop to_stop;

    public PassFromStop getFrom_stop() {
        return from_stop;
    }

    public void setFrom_stop(PassFromStop from_stop) {
        this.from_stop = from_stop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PassToStop getTo_stop() {
        return to_stop;
    }

    public void setTo_stop(PassToStop to_stop) {
        this.to_stop = to_stop;
    }
}
