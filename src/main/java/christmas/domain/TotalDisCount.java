package christmas.domain;

public class TotalDisCount {

    private static final Integer STANDARD_DAY_DISCOUNT = 1000;
    private static final Integer DISCOUNT_PER_DAY = 100;
    private static final Integer DAY_DISCOUNT_DUE_DAY = 25;
    private static final Integer NONE_DISCOUNT = 0;
    private final Integer dayDiscount;


    public TotalDisCount(final ReservationDate reservationDate) {
        this.dayDiscount = calculateDayDiscount(reservationDate);
    }

    private Integer calculateDayDiscount(final ReservationDate reservationDate) {
        Integer day = reservationDate.calculateAddDay();
        if (day > DAY_DISCOUNT_DUE_DAY) {
            return NONE_DISCOUNT;
        }
        return STANDARD_DAY_DISCOUNT + DISCOUNT_PER_DAY * day;
    }
}
