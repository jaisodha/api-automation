package pojo;

public class Profile {
    private boolean cached;
    public ProfileData data;
    private boolean success;

    public boolean isCached() {
        return cached;
    }

    public ProfileData getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}
