package christmas.io;

import christmas.domain.ReservationDate;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager() {
        this.inputView = new InputView();
        this.inputMapper = new InputMapper();
    }

    public ReservationDate readReservationDate() {
        final String input = inputView.readReservationDate();
        return inputMapper.toReservationDate(input);
    }
}
