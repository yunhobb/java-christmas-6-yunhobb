package christmas.domain;

public class TotalOrderPrice {

    private static final int GIVEAWAY_EVENT_MIN_PRICE = 120_000;
    private final Integer price;

    public TotalOrderPrice(final Integer price) {
        this.price = price;
    }

    public boolean checkGiveawayEvent() {
        return price >= GIVEAWAY_EVENT_MIN_PRICE;
    }

    public Integer toPrice() {
        return this.price;
    }

    public Integer getTotalPrice(final TotalDiscount totalDiscount) {
        return this.price - totalDiscount.getTotalDiscount();
    }
}
