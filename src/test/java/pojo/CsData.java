package pojo;

import java.util.List;

public class CsData {

    private String cta;
    private String inactiveCta;
    public List<routes> routes;
    private String subCta;

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getInactiveCta() {
        return inactiveCta;
    }

    public void setInactiveCta(String inactiveCta) {
        this.inactiveCta = inactiveCta;
    }

    public List<pojo.routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<pojo.routes> routes) {
        this.routes = routes;
    }

    public String getSubCta() {
        return subCta;
    }

    public void setSubCta(String subCta) {
        this.subCta = subCta;
    }


}
