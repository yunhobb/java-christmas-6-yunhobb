package christmas.io;

import christmas.domain.ExpectedDate;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager() {
        this.inputView = new InputView();
        this.inputMapper = new InputMapper();
    }

    public ExpectedDate readExpectedDate() {
        final String input = inputView.readExpectedDate();
        return inputMapper.toExpectedDate(input);
    }
}
