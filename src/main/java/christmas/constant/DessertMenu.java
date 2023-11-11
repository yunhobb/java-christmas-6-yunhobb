package christmas.constant;

import java.util.Arrays;
import java.util.Objects;

public enum DessertMenu {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    NONE("none", 0);

    private final String menuName;
    private final Integer price;

    DessertMenu(final String menuName, final Integer price) {
        this.menuName = menuName;
        this.price = price;
    }

    public static DessertMenu matchMenu(final String menuName) {
        return Arrays.stream(DessertMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }
}
