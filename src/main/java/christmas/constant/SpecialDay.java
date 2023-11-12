package christmas.constant;

import java.util.Arrays;

public enum SpecialDay {
    THREE(3),
    TEN(10),
    SEVENTEEN(17),
    TWENTY_FOUR(24),
    TWENTY_FIVE(25),
    THIRTY_ONE(31);

    private final Integer day;

    SpecialDay(final Integer day) {
        this.day = day;
    }

    public static boolean isSpecialDay(final Integer day) {
        return Arrays.stream(SpecialDay.values())
                .anyMatch(specialDay -> specialDay.day.equals(day));
    }
}
