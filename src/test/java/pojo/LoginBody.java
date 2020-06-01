package pojo;

public class LoginBody {
    private String loginType;
    private boolean newDevice;
    private boolean newUser;
    private String otp;
    private String phoneNumber;
    private boolean policyPerused;

    // Getter Methods

    public String getLoginType() {
        return loginType;
    }

    public boolean getNewDevice() {
        return newDevice;
    }

    public boolean getNewUser() {
        return newUser;
    }

    public String getOtp() {
        return otp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getPolicyPerused() {
        return policyPerused;
    }

    // Setter Methods

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setNewDevice(boolean newDevice) {
        this.newDevice = newDevice;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPolicyPerused(boolean policyPerused) {
        this.policyPerused = policyPerused;
    }
}