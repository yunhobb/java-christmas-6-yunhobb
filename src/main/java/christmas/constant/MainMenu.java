package christmas.constant;

import java.util.Arrays;
import java.util.Objects;

public enum MainMenu {
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_LIP("바비큐립", 54_000),
    SEA_FOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS("크리스마스파스타", 25_000),
    NONE("none", 0);

    private final String menuName;
    private final Integer price;

    MainMenu(final String menuName, final Integer price) {
        this.menuName = menuName;
        this.price = price;
    }

    public static MainMenu matchMenu(final String menuName) {
        return Arrays.stream(MainMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }
}
