package christmas.formatter;

import christmas.constant.ProcessMessage;
import christmas.domain.OrderMenu;
import java.util.Map;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";

    public String formatOrderMenu(final OrderMenu orderMenu) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> menuWithCount = orderMenu.getMenuWithCount();
        for (Map.Entry<String, Integer> entry : menuWithCount.entrySet()) {
            String menu = entry.getKey();
            Integer count = entry.getValue();
            String output = String.format(ProcessMessage.ORDER_TEMPLATE.toMessage(), menu, count);
            stringBuilder.append(output).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
