package pojo;

public class LoginResponse {

    private boolean cached;
    LoginData loginDataObject;
    private boolean success;


    // Getter Methods

    public boolean getCached() {
        return cached;
    }

    public LoginData getData() {
        return loginDataObject;
    }

    public boolean getSuccess() {
        return success;
    }

    // Setter Methods

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public void setData(LoginData loginDataObject) {
        this.loginDataObject = loginDataObject;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

