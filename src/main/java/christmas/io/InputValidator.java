package christmas.io;

import christmas.constant.ExceptionMessage;
import christmas.constant.RegexPattern;

public class InputValidator {

    public void validateNumeric(final String input) {
        if (RegexPattern.isNotNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.toMessage());
        }
    }
}
