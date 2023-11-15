package christmas.domain;

import christmas.constant.message.ExceptionMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservationDate {

    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    private static final LocalDate EVENT_START_DAY = LocalDate.of(EVENT_YEAR, EVENT_MONTH, START_DATE);

    private final LocalDate localDate;

    public ReservationDate(final Integer date) {
        validateDate(date);
        this.localDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, date);
    }

    private void validateDate(final Integer date) {
        if (date < START_DATE || date > END_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.toMessage());
        }
    }

    public Integer calculateAddDay() {
        return Math.toIntExact(EVENT_START_DAY.until(localDate, ChronoUnit.DAYS));
    }

    public boolean isHoliday() {
        DayOfWeek weekend = localDate.getDayOfWeek();
        return weekend == DayOfWeek.FRIDAY || weekend == DayOfWeek.SATURDAY;
    }

    public Integer getDay() {
        return localDate.getDayOfMonth();
    }
}
