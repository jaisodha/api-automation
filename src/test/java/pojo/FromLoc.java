package pojo;

import java.util.List;

public class FromLoc {

    private String id;
    private float lat;
    private float lng;
    private String name;
    public List<pickupPointTagDatas> pickupPointTagDatas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<pojo.pickupPointTagDatas> getPickupPointTagDatas() {
        return pickupPointTagDatas;
    }

    public void setPickupPointTagDatas(List<pojo.pickupPointTagDatas> pickupPointTagDatas) {
        this.pickupPointTagDatas = pickupPointTagDatas;
    }




}
