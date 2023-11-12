package christmas.domain;

import christmas.constant.ExceptionMessage;
import java.time.LocalDate;

public class ReservationDate {

    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int EVENT_YEAR = 2023;
    private static final int EVNET_MONTH = 12;

    private final LocalDate localDate;

    public ReservationDate(final Integer date) {
        validateDate(date);
        this.localDate = LocalDate.of(EVENT_YEAR, EVNET_MONTH, date);
    }

    private void validateDate(final Integer date) {
        if (date < START_DATE || date > END_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INITIALIZED.toMessage());
        }
    }
}
