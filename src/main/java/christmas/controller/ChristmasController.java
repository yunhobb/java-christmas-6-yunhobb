package christmas.controller;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalDiscount;
import christmas.io.InputManager;
import christmas.io.OutputView;
import christmas.service.ChristmasService;

public class ChristmasController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final ChristmasService christmasService;

    public ChristmasController(
            final OutputView outputView, final InputManager inputManager, final ChristmasService christmasService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.christmasService = christmasService;
    }

    public void run() {
        outputView.printGameStartMessage();
        outputView.printReservationDateRequest();
        final ReservationDate reservationDate = inputManager.readReservationDate();
        christmasService.saveReservationDate(reservationDate);
        outputView.printMenuWithCountRequest();
        final OrderMenu orderMenu = inputManager.readOrderMenu();
        outputView.printOutputStart();
        christmasService.saveOrderMenu(orderMenu);
        final OrderManager orderManager = christmasService.managing();
        christmasService.calculateOrderPrice();
        final TotalDiscount totalDiscount =christmasService.calculateTotalDiscount();
        outputView.printOrderMenu(orderMenu);
        outputView.printTotalOrderPrice(orderManager.getTotalOrderPrice());
        outputView.printServiceMenu(orderManager.getTotalOrderPrice());
        outputView.printBenefits(totalDiscount, orderManager.getTotalOrderPrice());
        outputView.printTotalDiscount(totalDiscount, orderManager.getTotalOrderPrice());
        outputView.printTotalPrice(totalDiscount, orderManager.getTotalOrderPrice());
        outputView.printBadge(totalDiscount, orderManager.getTotalOrderPrice());
    }
}
