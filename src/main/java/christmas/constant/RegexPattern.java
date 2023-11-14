package christmas.constant;

import java.util.regex.Pattern;

public enum RegexPattern {
    NUMERIC_PATTERN(Pattern.compile("\\d+")),
    ORDER_MENU_PATTERN(Pattern.compile("^[a-zA-Z]+-\\d+$"));

    private final Pattern pattern;

    RegexPattern(final Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotNumeric(final String input) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(input).matches();
    }

    public static boolean isOrderMenuFormat(final String input) {
        Pattern pattern = ORDER_MENU_PATTERN.pattern;
        return !pattern.matcher(input).matches();
    }
}
