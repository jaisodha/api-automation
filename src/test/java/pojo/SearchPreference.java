package pojo;

import java.util.List;

public class SearchPreference {
    private boolean cached;
    public List<SearchPreferenceData> data;
    private String errorCode = null;
    private String errors = null;
    private String message = null;
    private boolean success;

    public boolean getCached() {
        return cached;
    }

    public List<SearchPreferenceData> getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}
