package christmas.domain;

public class Number {

    private final Integer value;

    public Number(final Integer value) {
        this.value = value;
    }

    public Number(final Number number) {
        this.value = number.value;
    }
}
