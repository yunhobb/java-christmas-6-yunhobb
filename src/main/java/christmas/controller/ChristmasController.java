package christmas.controller;

import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalDiscount;
import christmas.domain.TotalOrderPrice;
import christmas.io.InputManager;
import christmas.io.OutputView;
import christmas.service.ChristmasService;
import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final ChristmasService christmasService;

    public ChristmasController(
            final OutputView outputView,
            final InputManager inputManager,
            final ChristmasService christmasService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.christmasService = christmasService;
    }

    public void run() {
        outputView.printGameStartMessage();
        readReservationDate();
        final OrderMenu orderMenu = readOrderMenu();
        final TotalOrderPrice totalOrderPrice = christmasService.calculateOrderPrice();
        final TotalDiscount totalDiscount = christmasService.calculateTotalDiscount();
        printEventBenefits(orderMenu, totalOrderPrice, totalDiscount);
    }

    private void readReservationDate() {
        retryUntilSuccessWithoutReturn(() -> {
            outputView.printReservationDateRequest();
            final ReservationDate reservationDate = inputManager.readReservationDate();
            christmasService.saveReservationDate(reservationDate);
        });
    }

    private OrderMenu readOrderMenu() {
        return retryUntilSuccessWithReturn(() -> {
            outputView.printMenuWithCountRequest();
            final OrderMenu orderMenu = inputManager.readOrderMenu();
            christmasService.saveOrderMenu(orderMenu);
            christmasService.managing();
            return orderMenu;
        });
    }

    private void printEventBenefits(
            final OrderMenu orderMenu, final TotalOrderPrice totalOrderPrice, final TotalDiscount totalDiscount) {
        outputView.printOutputStart();
        outputView.printOrderMenu(orderMenu);
        outputView.printTotalOrderPrice(totalOrderPrice);
        outputView.printGiveAwayMenu(totalOrderPrice);
        outputView.printBenefits(totalDiscount, totalOrderPrice);
        outputView.printTotalDiscount(totalDiscount, totalOrderPrice);
        outputView.printTotalPrice(totalDiscount, totalOrderPrice);
        outputView.printBadge(totalDiscount, totalOrderPrice);
    }

    private <T> T retryUntilSuccessWithReturn(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private void retryUntilSuccessWithoutReturn(final MethodParameter parameter) {
        while (true) {
            try {
                parameter.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}
