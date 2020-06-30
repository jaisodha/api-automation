package pojo;

public class RegisterBody {
    private String email;
    private String gender;
    private float homeLat;
    private float homeLng;
    private String homeLocation;
    private String name;
    private float workLat;
    private float workLng;
    private String workLocation;


    // Getter Methods

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public float getHomeLat() {
        return homeLat;
    }

    public float getHomeLng() {
        return homeLng;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public String getName() {
        return name;
    }

    public float getWorkLat() {
        return workLat;
    }

    public float getWorkLng() {
        return workLng;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    // Setter Methods

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeLat(float homeLat) {
        this.homeLat = homeLat;
    }

    public void setHomeLng(float homeLng) {
        this.homeLng = homeLng;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkLat(float workLat) {
        this.workLat = workLat;
    }

    public void setWorkLng(float workLng) {
        this.workLng = workLng;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}
