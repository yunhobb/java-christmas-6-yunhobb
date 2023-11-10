package christmas.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readExpectedDate() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }
}
