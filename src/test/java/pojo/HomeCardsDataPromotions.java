package pojo;

import java.util.List;

public class HomeCardsDataPromotions {
    private float autoscroll_interval;
    List<HomeCardsDataPromotionsCards> cards;

    public float getAutoscroll_interval() {
        return autoscroll_interval;
    }

    public void setAutoscroll_interval(float autoscroll_interval) {
        this.autoscroll_interval = autoscroll_interval;
    }

    public List<HomeCardsDataPromotionsCards> getCards() {
        return cards;
    }

    public void setCards(List<HomeCardsDataPromotionsCards> cards) {
        this.cards = cards;
    }
}
