package christmas.domain;

import christmas.constant.SpecialDay;

public class TotalDiscount {

    private static final Integer STANDARD_DAY_DISCOUNT = 1000;
    private static final Integer DISCOUNT_PER_DAY = 100;
    private static final Integer DAY_DISCOUNT_DUE_DAY = 25;
    private static final Integer NONE_DISCOUNT = 0;
    private static final Integer WEEKEND_DISCOUNT = 2023;
    private static final Integer SPECIAL_DISCOUNT = 1000;
    private final Integer dayDiscount;
    private final Integer weekendDiscount;
    private final Integer specialDiscount;


    public TotalDiscount(final ReservationDate reservationDate, final OrderManager orderManager) {
        this.dayDiscount = calculateDayDiscount(reservationDate);
        this.weekendDiscount = calculateWeekendDiscount(reservationDate, orderManager);
        this.specialDiscount = calculateSpecialDiscount(reservationDate);
    }

    private Integer calculateDayDiscount(final ReservationDate reservationDate) {
        Integer day = reservationDate.calculateAddDay();
        if (day > DAY_DISCOUNT_DUE_DAY) {
            return NONE_DISCOUNT;
        }
        return STANDARD_DAY_DISCOUNT + DISCOUNT_PER_DAY * day;
    }

    private Integer calculateWeekendDiscount(final ReservationDate reservationDate, final OrderManager orderManager) {
        Integer weekendDiscountCount = orderManager.getDiscountMenuCount(reservationDate);
        return WEEKEND_DISCOUNT * weekendDiscountCount;
    }

    private Integer calculateSpecialDiscount(final ReservationDate reservationDate) {
        if (SpecialDay.isSpecialDay(reservationDate.getDay())) {
            return SPECIAL_DISCOUNT;
        }
        return NONE_DISCOUNT;
    }
}
