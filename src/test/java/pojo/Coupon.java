package pojo;

public class Coupon {

    private String couponAppliedMessage;
    private String couponCode;
    private String couponDescription;
    private String couponExpiryDate;
    private float discountedFare;
    private float subscriptionCountOnRoute;

    private String activeCouponId;

    public String getActiveCouponId() {
        return activeCouponId;
    }

    public void setActiveCouponId(String activeCouponId) {
        this.activeCouponId = activeCouponId;
    }

    public String getCouponAppliedMessage() {
        return couponAppliedMessage;
    }

    public void setCouponAppliedMessage(String couponAppliedMessage) {
        this.couponAppliedMessage = couponAppliedMessage;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getCouponExpiryDate() {
        return couponExpiryDate;
    }

    public void setCouponExpiryDate(String couponExpiryDate) {
        this.couponExpiryDate = couponExpiryDate;
    }

    public float getDiscountedFare() {
        return discountedFare;
    }

    public void setDiscountedFare(float discountedFare) {
        this.discountedFare = discountedFare;
    }

    public float getSubscriptionCountOnRoute() {
        return subscriptionCountOnRoute;
    }

    public void setSubscriptionCountOnRoute(float subscriptionCountOnRoute) {
        this.subscriptionCountOnRoute = subscriptionCountOnRoute;
    }




}