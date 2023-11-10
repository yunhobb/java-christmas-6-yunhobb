package christmas;

import christmas.controller.ChristmasController;

public class Application {
    public static void main(String[] args) {

        final ChristmasController christmasController = new ChristmasController();
        christmasController.run();
    }
}
