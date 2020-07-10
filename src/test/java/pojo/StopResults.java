package pojo;

import java.util.List;

public class StopResults {

    private boolean cached;
    public List< StopResultsData > data;
    private boolean success;

    public boolean getCached() {
        return cached;
    }

    public List<StopResultsData> getData() {
        return data;
    }

    public boolean getSuccess() {
        return success;
    }
}
