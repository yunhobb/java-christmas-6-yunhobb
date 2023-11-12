package christmas.formatter;

import christmas.constant.ProcessMessage;
import christmas.domain.OrderMenu;
import christmas.domain.TotalOrderPrice;
import java.util.Map;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";
    private static final String CHAMPAGNE_SERVICE = "샴페인 1개";
    private static final String DO_NOT_EXIST = "없음";

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

    public String formatTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        return String.format(ProcessMessage.TOTAL_ORDER_PRICE_TEMPLATE.toMessage(), totalOrderPrice.toPrice());
    }

    public String formatServiceMenu(final TotalOrderPrice totalOrderPrice) {
        if (totalOrderPrice.checkServiceEvent()) {
            return CHAMPAGNE_SERVICE;
        }
        return DO_NOT_EXIST;
    }
}
