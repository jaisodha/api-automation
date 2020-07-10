package pojo;

import java.util.List;

public class RescheduleSlotsData {

    private String cta;
    private String subCta;
    private String inactiveCta;
    public List<RescheduleSlotsDataRoutes> routes;

    public String getCta() {
        return cta;
    }

    public String getSubCta() {
        return subCta;
    }

    public String getInactiveCta() {
        return inactiveCta;
    }

    public List<RescheduleSlotsDataRoutes> getRoutes() {
        return routes;
    }
}
