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
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;
    private final List<String> elements;

    public OrderMenu(final List<String> elements) {
        validateOrderMenuFormat(elements);
        this.elements = elements;
    }

    private void validateOrderMenuFormat(final List<String> elements) {
        elements.stream()
                .filter(RegexPattern::isNotOrderMenuFormat)
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage()));
    }

    public Map<String, Integer> getMenuWithCount() {
        final Map<String, Integer> menuWithCount = new HashMap<>();
        for (String element : elements) {
            String[] parts = element.split(MENU_COUNT_DELIMITER);
            validateNonMenu(parts[MENU_INDEX]);
            validateMenuCountNumeric(parts[COUNT_INDEX]);
            validateDuplicateMenu(menuWithCount, parts[MENU_INDEX]);
            validateMinMenuCount(parts[COUNT_INDEX]);
            menuWithCount.put(parts[MENU_INDEX], Integer.parseInt(parts[COUNT_INDEX]));
        }
        validateMaxMenuCount(menuWithCount);
        validateOnlyDrinkMenu(menuWithCount);
        return menuWithCount;
    }

    private void validateNonMenu(final String input) {
        if (ChristmasMenu.isNotIncludeMenu(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
        }
    }

    private void validateMenuCountNumeric(final String input) {
        if (RegexPattern.isNotNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
        }
    }

    private void validateDuplicateMenu(final Map<String, Integer> menuWithCount, final String input) {
        if (menuWithCount.containsKey(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
        }
    }

    private void validateMinMenuCount(final String input) {
        if (Integer.parseInt(input) < MIN_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
        }
    }

    private void validateMaxMenuCount(final Map<String, Integer> menuWithCount) {
        Integer total = menuWithCount.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        validateMaxMenuCount(total);
    }

    private void validateMaxMenuCount(final Integer total) {
        if (total > LIMIT_MENU_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MAX_COUNT.toMessage());
        }
    }

    private void validateOnlyDrinkMenu(final Map<String, Integer> menuWithCount) {
        if (ChristmasMenu.isAllDrink(menuWithCount)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_DRINK_ONLY.toMessage());
        }
    }
}
