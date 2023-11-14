package christmas.constant;

public enum ExceptionMessage {
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_MENU_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_MAX_COUNT("20개가 초과하게 구매할수 없습니다."),
    INVALID_ORDER_DRINK_ONLY("음료만 주문할 수 없습니다.");


    private static final String ERROR_TAG = "[ERROR] ";

    private final String message;

    ExceptionMessage(final String message) {
        this.message = ERROR_TAG + message;
    }

    public String toMessage() {
        return this.message;
    }
}
