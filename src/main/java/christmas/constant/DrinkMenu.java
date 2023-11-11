package christmas.constant;

import java.util.Arrays;
import java.util.Objects;

public enum DrinkMenu {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000),
    NONE("none", 0);

    private final String menuName;
    private final Integer price;

    DrinkMenu(final String menuName, final Integer price) {
        this.menuName = menuName;
        this.price = price;
    }

    public static DrinkMenu matchMenu(final String menuName) {
        return Arrays.stream(DrinkMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }
}
