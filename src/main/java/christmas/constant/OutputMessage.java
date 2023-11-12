package christmas.constant;

public enum OutputMessage {
    CHAMPAGNE_SERVICE("샴페인 1개"),
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인: -%,d원"),
    WEEKDAY_DISCOUNT("평일 할인: -%,d원"),
    SPECIAL_DISCOUNT("특별 할인: -1,000원"),
    SERVICE_EVENT("증정 이벤트: -25,000원"),
    NO_DISCOUNT("0원"),
    DO_NOT_EXIST("없음"),
    TOTAL_DISCOUNT_TEMPLATE("-%,d원"),
    TOTAL_PRICE_TEMPLATE("%,d원")

    ;

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
