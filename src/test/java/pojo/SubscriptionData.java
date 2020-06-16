package pojo;

import java.util.List;

public class SubscriptionData {

    private String destination_stop_id;
    private boolean is_first_transaction;
    private String origin_stop_id;
    public List<Sections> sections;


    public String getDestination_stop_id() {
        return destination_stop_id;
    }

    public void setDestination_stop_id(String destination_stop_id) {
        this.destination_stop_id = destination_stop_id;
    }




    public boolean getIs_first_transaction() {
        return is_first_transaction;
    }

    public void setIs_first_transaction(boolean is_first_transaction) {
        this.is_first_transaction = is_first_transaction;
    }




    public String getOrigin_stop_id() {
        return origin_stop_id;
    }

    public void setOrigin_stop_id(String origin_stop_id) {
        this.origin_stop_id = origin_stop_id;
    }

    public List<Sections> getSections() {
        return sections;
    }

    public void setSections(List<Sections> sections) {
        this.sections = sections;
    }


}
