package christmas.constant;

public enum ProcessMessage {
    GAME_START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

    private final String message;

    ProcessMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
