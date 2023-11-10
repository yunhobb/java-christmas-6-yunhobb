package christmas.constant;

import java.util.regex.Pattern;

public enum RegexPattern {
    NUMERIC_PATTERN(Pattern.compile("\\d+"));

    private final Pattern pattern;

    RegexPattern(final Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotNumeric(String input) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(input).matches();
    }
}
