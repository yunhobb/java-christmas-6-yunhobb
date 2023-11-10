package christmas.domain;

import christmas.constant.ExceptionMessage;

public class ReservationDate {

    private static final int START_DATE = 1;
    private static final int END_DATE = 31;

    private final Number number;

    public ReservationDate(final Integer number) {
        validateDate(number);
        this.number = new Number(number);
    }

    private void validateDate(final Integer value) {
        if (value < START_DATE || value > END_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INITIALIZED.toMessage());
        }
    }
}
