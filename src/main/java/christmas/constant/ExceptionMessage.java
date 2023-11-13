package christmas.constant;

public enum ExceptionMessage {
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다."),
    NOT_NUMBER("입력값은 숫자여야 합니다."),
    INVALID_DATE("날짜는 1 ~ 31 사이의 범위여야 합니다."),
    INVALID_ORDER_MENU_FORMAT("잘못된 주문 형식입니다."),
    INVALID_ORDER_MENU("없는 메뉴입니다."),
    INVALID_ORDER_MIN_COUNT("1개 이상을 주문 하셔야 합니다."),
    DUPLICATE_MENU_ORDER("음식을 중복하여 주문 하셨습니다."),
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
