package christmas.io;

import christmas.constant.ProcessMessage;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(ProcessMessage.GAME_START.toMessage());
    }

    public void printReservationDateRequest() {
        System.out.println(ProcessMessage.RESERVATION_DATE_REQUEST.toMessage());
    }

    public void printMenuWithCountRequest() {
        System.out.println(ProcessMessage.MENU_WITH_COUNT_REQUEST.toMessage());
    }
}
