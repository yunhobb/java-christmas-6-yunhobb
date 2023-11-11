package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.constant.RegexPattern;
import java.util.List;

public class OrderMenu {

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

    public List<String> toelements() {
        return List.copyOf(elements);
    }
}
