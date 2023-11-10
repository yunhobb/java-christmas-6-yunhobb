package christmas.constant;

public enum ProcessMessage {
    GAME_START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    RESERVATION_DATE_REQUEST("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    ProcessMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
