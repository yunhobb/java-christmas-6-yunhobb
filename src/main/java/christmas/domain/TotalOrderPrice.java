package christmas.domain;

public class TotalOrderPrice {

    private static final Integer CHAMPAGNE_SERVICE = 120_000;
    private final Integer price;

    public TotalOrderPrice(final Integer price) {
        this.price = price;
    }

    public boolean checkChampainEvent() {
        return price >= CHAMPAGNE_SERVICE;
    }

    public Integer toPrice() {
        return this.price;
    }
}
