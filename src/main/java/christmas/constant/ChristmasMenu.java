package christmas.constant;

import java.util.Arrays;
import java.util.Objects;

public enum ChristmasMenu {
    //Appetizer
    MUSHROOM_SOUP("양송이수프", 6_000, MenuConstant.APPETIZER.toCourse()),
    TAPAS("타파스", 5_500, MenuConstant.APPETIZER.toCourse()),
    CAESAR_SALAD("시저셀러드", 8_000, MenuConstant.APPETIZER.toCourse()),

    //MainMenu
    T_BONE_STEAK("티본스테이크", 55_000, MenuConstant.MAIN.toCourse()),
    BARBECUE_LIP("바비큐립", 54_000, MenuConstant.MAIN.toCourse()),
    SEA_FOOD_PASTA("해산물파스타", 35_000, MenuConstant.MAIN.toCourse()),
    CHRISTMAS("크리스마스파스타", 25_000, MenuConstant.MAIN.toCourse()),

    //DessertMenu
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuConstant.DESSERT.toCourse()),
    ICE_CREAM("아이스크림", 5_000, MenuConstant.DESSERT.toCourse()),

    //DrinkMenu
    ZERO_COKE("제로콜라", 3_000, MenuConstant.DRINK.toCourse()),
    RED_WINE("레드와인", 60_000, MenuConstant.DRINK.toCourse()),
    CHAMPAGNE("샴페인", 25_000, MenuConstant.DRINK.toCourse()),

    NONE("none", 0, "none");

    private final String menuName;
    private final Integer price;
    private final String course;

    ChristmasMenu(final String menuName, final Integer price, final String course) {
        this.menuName = menuName;
        this.price = price;
        this.course = course;
    }

    public static ChristmasMenu matchMenu(final String menuName) {
        return Arrays.stream(ChristmasMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean isNotIncludeMenu(final String menuName) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.menuName.equals(menuName));
    }
}
