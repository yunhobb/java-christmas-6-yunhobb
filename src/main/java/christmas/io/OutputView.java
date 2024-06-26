package christmas.io;

import christmas.constant.message.ProcessMessage;
import christmas.domain.OrderMenu;
import christmas.domain.TotalDiscount;
import christmas.domain.TotalOrderPrice;
import christmas.formatter.OutputFormatter;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView(final OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printGameStartMessage() {
        System.out.println(ProcessMessage.GAME_START.toMessage());
    }

    public void printReservationDateRequest() {
        System.out.println(ProcessMessage.RESERVATION_DATE_REQUEST.toMessage());
    }

    public void printMenuWithCountRequest() {
        System.out.println(ProcessMessage.MENU_WITH_COUNT_REQUEST.toMessage());
    }

    public void printOutputStart() {
        System.out.println(ProcessMessage.OUTPUT_STATISTICS.toMessage());
    }

    public void printOrderMenu(final OrderMenu orderMenu) {
        System.out.println(ProcessMessage.ORDER_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatOrderMenu(orderMenu));
    }

    public void printTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.TOTAL_ORDER_PRICE_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatTotalOrderPrice(totalOrderPrice));
    }

    public void printGiveAwayMenu(final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.GIVEAWAY_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatGiveAwayMenu(totalOrderPrice));
    }

    public void printBenefits(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.BENEFITS_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatBenefits(totalDiscount, totalOrderPrice));
    }

    public void printTotalDiscount(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.TOTAL_DISCOUNT_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatTotalDiscount(totalDiscount, totalOrderPrice));
    }

    public void printTotalPrice(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.TOTAL_PRICE_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatTotalPrice(totalDiscount, totalOrderPrice));
    }

    public void printBadge(final TotalDiscount totalDiscount, final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.BADGE_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatBadge(totalDiscount, totalOrderPrice));
    }

    public void printExceptionMessage(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
