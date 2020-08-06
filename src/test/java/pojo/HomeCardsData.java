package pojo;

public class HomeCardsData {

    private String search_placeholder;
    public HomeCardsDataPromotions promotions;
    public HomeCardsDataSessionsInfo sessions_info;

    public String getSearch_placeholder() {
        return search_placeholder;
    }

    public void setSearch_placeholder(String search_placeholder) {
        this.search_placeholder = search_placeholder;
    }

    public HomeCardsDataPromotions getPromotions() {
        return promotions;
    }

    public void setPromotions(HomeCardsDataPromotions promotions) {
        this.promotions = promotions;
    }

    public HomeCardsDataSessionsInfo getSessions_info() {
        return sessions_info;
    }

    public void setSessions_info(HomeCardsDataSessionsInfo sessions_info) {
        this.sessions_info = sessions_info;
    }
}
