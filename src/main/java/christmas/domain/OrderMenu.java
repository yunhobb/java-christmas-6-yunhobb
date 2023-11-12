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
    private final List<String> elements;

    public OrderMenu(List<String> elements) {
        validateOrderMenuFormat(elements);
        this.elements = elements;
    }

    private void validateOrderMenuFormat(List<String> elements) {
        for (String element : elements) {
            if (RegexPattern.isNotOrderMenuFormat(element)) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU_FORMAT.toMessage());
            }
        }
    }

    public Map<String, Integer> getMenuWithCount() {
        Map<String, Integer> menuWithCount = new HashMap<>();

        for (String element : elements) {
            String[] parts = element.split(MENU_COUNT_DELIMITER);
            validateMenu(parts[0]);
            validateMenuCount(parts[1]);
            menuWithCount.put(parts[0], Integer.parseInt(parts[1]));
        }
        return menuWithCount;
    }

    private void validateMenu(String part) {
        if (ChristmasMenu.isNotIncludeMenu(part)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MENU.toMessage());
        }
    }

    private void validateMenuCount(String part) {
        if (Integer.parseInt(part) < MIN_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_COUNT.toMessage());
        }
    }

    public List<String> toelements() {
        return List.copyOf(elements);
    }
}
