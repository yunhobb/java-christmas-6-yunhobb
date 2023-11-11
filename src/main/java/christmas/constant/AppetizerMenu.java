package christmas.constant;

import java.util.Arrays;
import java.util.Objects;

public enum AppetizerMenu {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저셀러드", 8_000),
    NONE("none", 0);

    private final String menuName;
    private final Integer price;

    AppetizerMenu(final String menuName, final Integer price) {
        this.menuName = menuName;
        this.price = price;
    }

    public static AppetizerMenu matchMenu(final String menuName) {
        return Arrays.stream(AppetizerMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }
}
