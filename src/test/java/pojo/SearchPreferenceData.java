package pojo;

import java.util.List;

public class SearchPreferenceData {

    private String flow;
    public List<SearchPreferenceDataProvider> provider;

    public String getFlow() {
        return flow;
    }

    public List<SearchPreferenceDataProvider> getProvider() {
        return provider;
    }
}
