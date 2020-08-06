package pojo;

import java.util.List;

public class ProfileData {
    public List<ProfileDataAddresses> addresses;
    private String email;
    private String encryptedReferId;
    public List < String > features;
    private String gender;
    private String id;
    private String name;
    private String push_notification_id = null;
    private String referId;
    private String referredBy = null;
    private String search_ftux_flow;
    private boolean sosEnabled;
    public List < ProfileDataUserSpecificFeature > user_specific_features;
    public List< ProfileDataUserTypes > user_types;
    private String zone_id;

    public List<ProfileDataAddresses> getAddresses() {
        return addresses;
    }

    public String getEmail() {
        return email;
    }

    public String getEncryptedReferId() {
        return encryptedReferId;
    }

    public List<String> getFeatures() {
        return features;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPush_notification_id() {
        return push_notification_id;
    }

    public String getReferId() {
        return referId;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public String getSearch_ftux_flow() {
        return search_ftux_flow;
    }

    public boolean isSosEnabled() {
        return sosEnabled;
    }

    public List<ProfileDataUserSpecificFeature> getUser_specific_features() {
        return user_specific_features;
    }

    public List<ProfileDataUserTypes> getUser_types() {
        return user_types;
    }

    public String getZone_id() {
        return zone_id;
    }
}
