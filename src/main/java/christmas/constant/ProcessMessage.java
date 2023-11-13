package christmas.constant;

public enum ProcessMessage {
    GAME_START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    RESERVATION_DATE_REQUEST("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENU_WITH_COUNT_REQUEST("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    OUTPUT_STATISTICS("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_STATISTICS("\n<주문 메뉴>"),
    ORDER_TEMPLATE("%s %d개"),
    TOTAL_ORDER_PRICE_STATISTICS("<할인 전 총주문 금액>"),
    TOTAL_ORDER_PRICE_TEMPLATE("%,d원"),
    SERVICE_STATISTICS("\n<증정 메뉴>"),
    BENEFITS_STATISTICS("\n<혜택 내역>"),
    TOTAL_DISCOUNT_STATISTICS("<총혜택 금액>"),
    TOTAL_PRICE_STATISTICS("\n<할인 후 에상 결제 금액>"),
    BADGE_STATISTICS("\n<12월 이벤트 배지>");



    private final String message;

    ProcessMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
