package pojo;

public class LoginResponse {

    private boolean cached;
    Data DataObject;
    private boolean success;


    // Getter Methods

    public boolean getCached() {
        return cached;
    }

    public Data getData() {
        return DataObject;
    }

    public boolean getSuccess() {
        return success;
    }

    // Setter Methods

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

