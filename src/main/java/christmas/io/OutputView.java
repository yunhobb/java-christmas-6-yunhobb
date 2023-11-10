package christmas.io;

import christmas.constant.ProcessMessage;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(ProcessMessage.GAME_START.toMessage());
    }
}
