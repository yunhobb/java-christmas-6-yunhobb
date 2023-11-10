package christmas.io;

import christmas.domain.ExpectedDate;

public class InputMapper {

    public ExpectedDate toExpectedDate(final String input) {
        final Integer number = Integer.parseInt(input);
        return new ExpectedDate(number);
    }
}
