package christmas.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum ChristmasMenu {
    //Appetizer
    MUSHROOM_SOUP("양송이수프", 6_000, MenuCategory.APPETIZER),
    TAPAS("타파스", 5_500, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저셀러드", 8_000, MenuCategory.APPETIZER),

    //MainMenu
    T_BONE_STEAK("티본스테이크", 55_000, MenuCategory.MAIN),
    BARBECUE_LIP("바비큐립", 54_000, MenuCategory.MAIN),
    SEA_FOOD_PASTA("해산물파스타", 35_000, MenuCategory.MAIN),
    CHRISTMAS("크리스마스파스타", 25_000, MenuCategory.MAIN),

    //DessertMenu
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuCategory.DESSERT),

    //DrinkMenu
    ZERO_COKE("제로콜라", 3_000, MenuCategory.DRINK),
    RED_WINE("레드와인", 60_000, MenuCategory.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuCategory.DRINK),

    NONE("none", 0, MenuCategory.NONE);

    private final String menuName;
    private final Integer price;
    private final MenuCategory course;

    ChristmasMenu(final String menuName, final Integer price, final MenuCategory course) {
        this.menuName = menuName;
        this.price = price;
        this.course = course;
    }

    public static boolean isNotIncludeMenu(final String menuName) {
        return Arrays.stream(ChristmasMenu.values())
                .noneMatch(christmasMenu -> christmasMenu.menuName.equals(menuName));
    }

    public static boolean isAllDrink(final Map<String, Integer> menuWithCount) {
        return menuWithCount.keySet().stream()
                .allMatch(key -> findByMenuName(key).getCourse() == MenuCategory.DRINK);
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

    public MenuCategory getCourse() {
        return course;
    }

}
