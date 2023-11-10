package christmas.io;

import christmas.domain.ReservationDate;

public class InputMapper {

    public ReservationDate toReservationDate(final String input) {
        final Integer number = Integer.parseInt(input);
        return new ReservationDate(number);
    }
}
