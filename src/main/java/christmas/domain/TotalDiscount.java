package christmas.domain;

import christmas.constant.SpecialDay;
import java.util.Objects;

public class TotalDiscount {

    private static final Integer STANDARD_DAY_DISCOUNT = 1000;
    private static final Integer DISCOUNT_PER_DAY = 100;
    private static final Integer DAY_DISCOUNT_DUE_DAY = 23;
    private static final Integer NONE_DISCOUNT = 0;
    private static final Integer WEEKEND_DISCOUNT = 2023;
    private static final Integer SPECIAL_DISCOUNT = 1000;
    private static final Integer SERVICES_DISCOUNT = 25000;
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
    public boolean isNotDayDiscount() {
        return !Objects.equals(this.dayDiscount, NONE_DISCOUNT);
    }

    public Integer toDayDiscount() {
        return dayDiscount;
    }

    public boolean isNotWeekendDiscount() {
        return !Objects.equals(this.weekendDiscount, NONE_DISCOUNT);
    }

    public Integer toWeekendDiscount() {
        return weekendDiscount;
    }

    public boolean isNotSpecialDiscount() {
        return !Objects.equals(this.specialDiscount, NONE_DISCOUNT);
    }

    public Integer getTotalDiscount(final TotalOrderPrice totalOrderPrice) {
        if (totalOrderPrice.checkServiceEvent()) {
            return this.dayDiscount + this.weekendDiscount + this.specialDiscount + SERVICES_DISCOUNT;
        }
        return this.dayDiscount + this.weekendDiscount + this.specialDiscount;
    }

    public Integer getTotalDiscount() {
        return this.dayDiscount + this.weekendDiscount + this.specialDiscount;
    }
}
