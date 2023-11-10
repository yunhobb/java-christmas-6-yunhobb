package christmas.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readReservationDate() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }

    public String readOrderMenu() {
        return Console.readLine();
    }
}
