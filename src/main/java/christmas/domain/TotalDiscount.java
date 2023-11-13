package christmas.domain;

import christmas.constant.SpecialDay;
import java.util.Objects;

public class TotalDiscount {

    private static final int STANDARD_DAY_DISCOUNT = 1_000;
    private static final int DISCOUNT_PER_DAY = 100;
    private static final int DAY_DISCOUNT_DUE_DAY = 23;
    private static final int NONE_DISCOUNT = 0;
    private static final int WEEKEND_DISCOUNT = 2_023;
    private static final int SPECIAL_DISCOUNT = 1_000;
    private static final int SERVICES_DISCOUNT = 25_000;
    private static final int MIN_ACCEPTABLE_DISCOUNT_AMOUNT = 10_000;
    private final Integer dayDiscount;
    private final Integer weekendDiscount;
    private final Integer specialDiscount;


    public TotalDiscount(final ReservationDate reservationDate, final OrderManager orderManager) {
        if (orderManager.getTotalOrderPrice().toPrice() < MIN_ACCEPTABLE_DISCOUNT_AMOUNT) {
            this.dayDiscount = NONE_DISCOUNT;
            this.weekendDiscount = NONE_DISCOUNT;
            this.specialDiscount = NONE_DISCOUNT;
            return;
        }
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
