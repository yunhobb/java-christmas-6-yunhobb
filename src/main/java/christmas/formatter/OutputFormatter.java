package christmas.formatter;

import christmas.constant.Badge;
import christmas.constant.OutputMessage;
import christmas.constant.ProcessMessage;
import christmas.domain.OrderMenu;
import christmas.domain.TotalDiscount;
import christmas.domain.TotalOrderPrice;
import java.util.Map;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";
    private static final int NO_DISCOUNT = 0;

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
            return OutputMessage.CHAMPAGNE_SERVICE.toMessage();
        }
        return OutputMessage.DO_NOT_EXIST.toMessage();
    }

    public String formatBenefits(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        StringBuilder stringBuilder = new StringBuilder();
        if (totalDiscount.isNotDayDiscount()) {
            stringBuilder.append(String.format(
                            OutputMessage.CHRISTMAS_D_DAY_DISCOUNT.toMessage(), totalDiscount.toDayDiscount()))
                    .append(NEW_LINE);
        }
        if (totalDiscount.isNotWeekendDiscount()) {
            stringBuilder.append(
                            String.format(OutputMessage.WEEKDAY_DISCOUNT.toMessage(), totalDiscount.toWeekendDiscount()))
                    .append(NEW_LINE);
        }
        if (totalDiscount.isNotSpecialDiscount()) {
            stringBuilder.append(OutputMessage.SPECIAL_DISCOUNT.toMessage()).append(NEW_LINE);
        }
        if (totalOrderPrice.checkServiceEvent()) {
            stringBuilder.append(OutputMessage.SERVICE_EVENT.toMessage()).append(NEW_LINE);
        }
        if (stringBuilder.length() == NO_DISCOUNT) {
            stringBuilder.append(OutputMessage.NO_DISCOUNT.toMessage()).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public String formatTotalDiscount(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        Integer totalDiscountPrice = totalDiscount.getTotalDiscount(totalOrderPrice);
        if (totalDiscountPrice == NO_DISCOUNT) {
            return OutputMessage.NO_DISCOUNT.toMessage();
        }
        return String.format(OutputMessage.TOTAL_DISCOUNT_TEMPLATE.toMessage(), totalDiscountPrice);
    }

    public String formatTotalPrice(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        return String.format(OutputMessage.TOTAL_PRICE_TEMPLATE.toMessage(),
                totalOrderPrice.getTotalPrice(totalDiscount));
    }

    public String formatBadge(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        return Badge.getBadge(totalDiscount.getTotalDiscount(totalOrderPrice)).toName();
    }
}
