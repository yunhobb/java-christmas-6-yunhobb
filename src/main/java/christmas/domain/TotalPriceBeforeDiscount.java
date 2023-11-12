package christmas.domain;

public class TotalPriceBeforeDiscount {

    private final Number number;

    public TotalPriceBeforeDiscount(final Integer value) {
        this.number = new Number(value);
    }

    public Number getNumber() {
        return number;
    }
}
