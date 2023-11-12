package christmas.io;

import christmas.constant.ProcessMessage;
import christmas.domain.OrderMenu;
import christmas.domain.TotalOrderPrice;
import christmas.formatter.OutputFormatter;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView() {
        this.outputFormatter = new OutputFormatter();
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

    public void printOrderMenu(final OrderMenu orderMenu) {
        System.out.println(ProcessMessage.ORDER_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatOrderMenu(orderMenu));
    }

    public void printTotalOrderPrice(final TotalOrderPrice totalOrderPrice) {
        System.out.println(ProcessMessage.TOTAL_ORDER_PRICE_STATISTICS.toMessage());
        System.out.println(outputFormatter.formatTotalOrderPrice(totalOrderPrice));
    }
}
