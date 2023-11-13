package christmas.domain;

import christmas.constant.ChristmasMenu;
import christmas.constant.ExceptionMessage;
import christmas.constant.RegexPattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMenu {

    private static final String MENU_COUNT_DELIMITER = "-";
    private static final int MIN_COUNT = 1;
    private static final int LIMIT_MENU_COUNT = 20;
    private final List<String> elements;

    public OrderMenu(final List<String> elements) {
        validateOrderMenuFormat(elements);
        this.elements = elements;
    }

    private void validateOrderMenuFormat(final List<String> elements) {
        for (String element : elements) {
            if (RegexPattern.isNotOrderMenuFormat(element)) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
            }
        }
    }

    public Map<String, Integer> getMenuWithCount() {
        final Map<String, Integer> menuWithCount = new HashMap<>();
        for (String element : elements) {
            String[] parts = element.split(MENU_COUNT_DELIMITER);
            validateMenu(parts[0]);
            validateCountNumeric(parts[1]);
            validateDuplicateMenu(menuWithCount, parts[0]);
            validateMenuCount(parts[1]);
            menuWithCount.put(parts[0], Integer.parseInt(parts[1]));
        }
        validateOverTwentyCount(menuWithCount);
        validateDrinkMenu(menuWithCount);
        return menuWithCount;
    }

    private void validateMenu(final String input) {
        if (ChristmasMenu.isNotIncludeMenu(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU.toMessage());
        }
    }

    private void validateDrinkMenu(final Map<String, Integer> menuWithCount) {
        if (ChristmasMenu.isAllDrink(menuWithCount)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_DRINK_ONLY.toMessage());
        }
    }

    private static void validateDuplicateMenu(final Map<String, Integer> menuWithCount, final String input) {
        if (menuWithCount.containsKey(input)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_MENU_ORDER.toMessage());
        }
    }

    private void validateOverTwentyCount(final Map<String, Integer> menuWithCount) {
        int total = 0;
        for (int value : menuWithCount.values()) {
            total += value;
        }
        if (total > LIMIT_MENU_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MAX_COUNT.toMessage());
        }
    }

    private void validateMenuCount(final String input) {
        if (Integer.parseInt(input) < MIN_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MIN_COUNT.toMessage());
        }
    }

    private void validateCountNumeric(final String input) {
        if (RegexPattern.isNotNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
        }
    }
}
