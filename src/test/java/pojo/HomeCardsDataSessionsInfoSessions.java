package pojo;

import java.util.List;

public class HomeCardsDataSessionsInfoSessions {
    private String header_text;
    private String type;
    List<HomeCardsDataSessionsInfoSessionsCards> cards;

    public String getHeader_text() {
        return header_text;
    }

    public void setHeader_text(String header_text) {
        this.header_text = header_text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<HomeCardsDataSessionsInfoSessionsCards> getCards() {
        return cards;
    }

    public void setCards(List<HomeCardsDataSessionsInfoSessionsCards> cards) {
        this.cards = cards;
    }
}
