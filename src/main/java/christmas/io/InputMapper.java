package christmas.io;

import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputMapper {

    private static final String MENU_DELIMITER = ",";

    public ReservationDate toReservationDate(final String input) {
        final Integer number = Integer.parseInt(input);
        return new ReservationDate(number);
    }

    public OrderMenu toOrderMenu(final String input) {
        return Arrays.stream(input.split(MENU_DELIMITER))
                .collect(Collectors.collectingAndThen(Collectors.toList(), OrderMenu::new));
    }
}
