package pojo;

import java.util.List;

public class Sections {

    private String header;
    public List<Passes> passes;
    private String scroll_type;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Passes> getPasses() {
        return passes;
    }

    public void setPasses(List<Passes> passes) {
        this.passes = passes;
    }

    public String getScroll_type() {
        return scroll_type;
    }

    public void setScroll_type(String scroll_type) {
        this.scroll_type = scroll_type;
    }

}
