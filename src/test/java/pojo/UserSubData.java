package pojo;

import java.util.List;

public class UserSubData {
    private String cta;
    private String sub_cta;
    private String tnc_text;
    public UserSubDataInfoDetails info_details;
    public UserSubOd od;
    public UserSubDataSubscriptionDetails subscription_details;
    public List<UserSubDataDetails> user_subscription_details;

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getSub_cta() {
        return sub_cta;
    }

    public void setSub_cta(String sub_cta) {
        this.sub_cta = sub_cta;
    }

    public String getTnc_text() {
        return tnc_text;
    }

    public void setTnc_text(String tnc_text) {
        this.tnc_text = tnc_text;
    }

    public UserSubDataInfoDetails getInfo_details() {
        return info_details;
    }

    public void setInfo_details(UserSubDataInfoDetails info_details) {
        this.info_details = info_details;
    }

    public UserSubDataSubscriptionDetails getSubscription_details() {
        return subscription_details;
    }

    public void setSubscription_details(UserSubDataSubscriptionDetails subscription_details) {
        this.subscription_details = subscription_details;
    }

    public List<UserSubDataDetails> getUser_subscription_details() {
        return user_subscription_details;
    }

    public void setUser_subscription_details(List<UserSubDataDetails> user_subscription_details) {
        this.user_subscription_details = user_subscription_details;
    }
    public UserSubOd getOd() {
        return od;
    }

    public void setOd(UserSubOd od) {
        this.od = od;
    }
}
