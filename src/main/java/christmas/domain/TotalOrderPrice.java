package christmas.domain;

public class TotalOrderPrice {

    private static final Integer SERVICE_EVENT_MIN_PRICE = 120_000;
    private final Integer price;

    public TotalOrderPrice(final Integer price) {
        this.price = price;
    }

    public boolean checkServiceEvent() {
        return price >= SERVICE_EVENT_MIN_PRICE;
    }

    public Integer toPrice() {
        return this.price;
    }
}
