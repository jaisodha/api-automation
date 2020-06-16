package pojo;

public class OtpBody {
    private boolean newDevice;
    private String phoneNumber;
    private boolean policyPerused;


    // Getter Methods

    public boolean getNewDevice() {
        return newDevice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getPolicyPerused() {
        return policyPerused;
    }

    // Setter Methods

    public void setNewDevice(boolean newDevice) {
        this.newDevice = newDevice;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPolicyPerused(boolean policyPerused) {
        this.policyPerused = policyPerused;
    }

}
