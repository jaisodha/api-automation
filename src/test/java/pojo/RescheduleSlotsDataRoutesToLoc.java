package pojo;

import java.util.List;

public class RescheduleSlotsDataRoutesToLoc {
    private String id;
    private float lat;
    private float lng;
    private String name;
    public List< RescheduleSlotsDataRoutesFromLocPickupPointTagDatas > pickupPointTagDatas;

    public String getId() {
        return id;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public List<RescheduleSlotsDataRoutesFromLocPickupPointTagDatas> getPickupPointTagDatas() {
        return pickupPointTagDatas;
    }
}
