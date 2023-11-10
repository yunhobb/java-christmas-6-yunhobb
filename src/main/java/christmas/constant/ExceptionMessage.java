package christmas.constant;

public enum ExceptionMessage {
    ERROR_TAG("[ERROR] "),
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return ERROR_TAG + this.message;
    }
}
