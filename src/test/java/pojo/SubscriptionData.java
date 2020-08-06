package pojo;

public class SubscriptionData {

    private String cta;
    public PassInfoDetails info_details;
    public PassOd od;
    public SubDetails subscription_details;
    private String tnc_text;

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public PassInfoDetails getInfo_details() {
        return info_details;
    }

    public void setInfo_details(PassInfoDetails info_details) {
        this.info_details = info_details;
    }

    public PassOd getOd() {
        return od;
    }

    public void setOd(PassOd od) {
        this.od = od;
    }

    public SubDetails getSubscription_details() {
        return subscription_details;
    }

    public void setSubscription_details(SubDetails subscription_details) {
        this.subscription_details = subscription_details;
    }

    public String getTnc_text() {
        return tnc_text;
    }

    public void setTnc_text(String tnc_text) {
        this.tnc_text = tnc_text;
    }
}
