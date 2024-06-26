package christmas.formatter;

import christmas.constant.Badge;
import christmas.constant.message.ResultMessage;
import christmas.constant.message.ProcessMessage;
import christmas.domain.OrderMenu;
import christmas.domain.TotalDiscount;
import christmas.domain.TotalOrderPrice;
import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";
    private static final int NO_DISCOUNT = 0;

    public String formatOrderMenu(final OrderMenu orderMenu) {
        return orderMenu.getMenuWithCount().entrySet().stream()
                .map(entry ->
                        String.format(ProcessMessage.ORDER_TEMPLATE.toMessage(), entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(NEW_LINE));
    }

    public String formatTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        return String.format(ProcessMessage.TOTAL_ORDER_PRICE_TEMPLATE.toMessage(), totalOrderPrice.toPrice());
    }

    public String formatGiveAwayMenu(final TotalOrderPrice totalOrderPrice) {
        if (totalOrderPrice.checkGiveawayEvent()) {
            return ResultMessage.CHAMPAGNE_GIVEAWAY.toMessage();
        }
        return ResultMessage.DO_NOT_EXIST.toMessage();
    }

    public String formatBenefits(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        StringBuilder stringbuilder = new StringBuilder();
        appendDayDiscountMessage(stringbuilder, totalDiscount);
        appendWeekendDiscountMessage(stringbuilder, totalDiscount);
        appendSpecialDiscountMessage(stringbuilder, totalDiscount);
        appendGiveawayEventMessage(stringbuilder, totalOrderPrice);
        appendNotExistMessage(stringbuilder);
        return stringbuilder.toString();
    }

    private void appendDayDiscountMessage(final StringBuilder stringbuilder, final TotalDiscount totalDiscount) {
        if (totalDiscount.isNotDayDiscount()) {
            stringbuilder.append(String.format(
                            ResultMessage.CHRISTMAS_D_DAY_DISCOUNT.toMessage(), totalDiscount.getDayDiscount()))
                    .append(NEW_LINE);
        }
    }

    private void appendWeekendDiscountMessage(final StringBuilder stringbuilder, final TotalDiscount totalDiscount) {
        if (totalDiscount.isNotWeekendDiscount()) {
            stringbuilder.append(String.format(
                    ResultMessage.WEEKDAY_DISCOUNT.toMessage(), totalDiscount.toWeekendDiscount())).append(NEW_LINE);
        }
    }

    private void appendSpecialDiscountMessage(final StringBuilder stringbuilder, final TotalDiscount totalDiscount) {
        if (totalDiscount.isNotSpecialDiscount()) {
            stringbuilder.append(ResultMessage.SPECIAL_DISCOUNT.toMessage()).append(NEW_LINE);
        }
    }

    private void appendGiveawayEventMessage(final StringBuilder stringbuilder, final TotalOrderPrice totalOrderPrice) {
        if (totalOrderPrice.checkGiveawayEvent()) {
            stringbuilder.append(ResultMessage.GIVEAWAY_EVENT.toMessage()).append(NEW_LINE);
        }
    }

    private void appendNotExistMessage(final StringBuilder stringbuilder) {
        if (stringbuilder.length() == NO_DISCOUNT) {
            stringbuilder.append(ResultMessage.DO_NOT_EXIST.toMessage()).append(NEW_LINE);
        }
    }

    public String formatTotalDiscount(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        Integer totalDiscountPrice = totalDiscount.getTotalDiscountWithTotalPrice(totalOrderPrice);
        if (totalDiscountPrice == NO_DISCOUNT) {
            return ResultMessage.NO_DISCOUNT.toMessage();
        }
        return String.format(ResultMessage.TOTAL_DISCOUNT_TEMPLATE.toMessage(), totalDiscountPrice);
    }

    public String formatTotalPrice(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        return String.format(ResultMessage.TOTAL_PRICE_TEMPLATE.toMessage(),
                totalOrderPrice.getTotalPrice(totalDiscount));
    }

    public String formatBadge(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        return Badge.getBadge(totalDiscount.getTotalDiscountWithTotalPrice(totalOrderPrice)).toName();
    }
}
