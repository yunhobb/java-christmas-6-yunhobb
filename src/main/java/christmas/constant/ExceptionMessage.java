package christmas.constant;

public enum ExceptionMessage {
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다."),
    NOT_NUMBER("입력값은 숫자여야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";

    private final String message;

    ExceptionMessage(final String message) {
        this.message = ERROR_TAG + message;
    }

    public String toMessage() {
        return this.message;
    }
}
