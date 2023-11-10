package christmas.controller;

import christmas.io.OutputView;

public class ChristmasController {

    private final OutputView outputView;

    public ChristmasController() {
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printGameStartMessage();
    }
}
