package christmas.controller;

import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.io.InputManager;
import christmas.io.OutputView;
import christmas.service.ChristmasService;

public class ChristmasController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final ChristmasService christmasService;

    public ChristmasController() {
        this.outputView = new OutputView();
        this.inputManager = new InputManager();
        this.christmasService = new ChristmasService();
    }

    public void run() {
        outputView.printGameStartMessage();
        outputView.printReservationDateRequest();
        final ReservationDate reservationDate = inputManager.readReservationDate();
        christmasService.saveReservationDate(reservationDate);
        outputView.printMenuWithCountRequest();
        final OrderMenu orderMenu = inputManager.readOrderMenu();
    }
}
