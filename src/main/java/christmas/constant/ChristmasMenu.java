package christmas.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum ChristmasMenu {
    //Appetizer
    MUSHROOM_SOUP("양송이수프", 6_000, MenuConstant.APPETIZER),
    TAPAS("타파스", 5_500, MenuConstant.APPETIZER),
    CAESAR_SALAD("시저셀러드", 8_000, MenuConstant.APPETIZER),

    //MainMenu
    T_BONE_STEAK("티본스테이크", 55_000, MenuConstant.MAIN),
    BARBECUE_LIP("바비큐립", 54_000, MenuConstant.MAIN),
    SEA_FOOD_PASTA("해산물파스타", 35_000, MenuConstant.MAIN),
    CHRISTMAS("크리스마스파스타", 25_000, MenuConstant.MAIN),

    //DessertMenu
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuConstant.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuConstant.DESSERT),

    //DrinkMenu
    ZERO_COKE("제로콜라", 3_000, MenuConstant.DRINK),
    RED_WINE("레드와인", 60_000, MenuConstant.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuConstant.DRINK),

    NONE("none", 0, MenuConstant.NONE);

    private final String menuName;
    private final Integer price;
    private final MenuConstant course;

    ChristmasMenu(final String menuName, final Integer price, final MenuConstant course) {
        this.menuName = menuName;
        this.price = price;
        this.course = course;
    }

    public static boolean isNotIncludeMenu(final String menuName) {
        return Arrays.stream(ChristmasMenu.values())
                .noneMatch(christmasMenu -> christmasMenu.menuName.equals(menuName));
    }

    public static boolean isDessert(final String menuName) {
        return Objects.equals(findByMenuName(menuName).getCourse(), MenuConstant.DESSERT);
    }

    public static boolean isMain(final String menuName) {
        return Objects.equals(findByMenuName(menuName).getCourse(), MenuConstant.MAIN);
    }

    public static boolean isAllDrink(final Map<String, Integer> menuWithCount) {
        return menuWithCount.keySet().stream()
                .allMatch(key -> findByMenuName(key).getCourse() == MenuConstant.DRINK);
    }

    private static ChristmasMenu findByMenuName(final String menuName) {
        return Arrays.stream(ChristmasMenu.values())
                .filter(v -> Objects.equals(menuName, v.menuName))
                .findFirst()
                .orElse(NONE);
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getPrice() {
        return price;
    }

    private MenuConstant getCourse() {
        return course;
    }

}
