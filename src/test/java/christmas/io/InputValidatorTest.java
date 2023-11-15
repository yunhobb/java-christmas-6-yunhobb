package christmas.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.constant.RegexPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator의")
class InputValidatorTest {

    final InputValidator inputValidator = new InputValidator();

    @DisplayName("숫자가 아니면 예외를 던지는")
    @Test
    void check_with_number() {
        //given
        final String input = "a";

        //when & then
        assertThatThrownBy(() -> inputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자면 정상적으로 반환하는가")
    @Test
    void check_without_number() {
        //given
        final String input = "1";

        //when & then
        assertThatNoException()
                .isThrownBy(() -> RegexPattern.isNotNumeric(input));
    }


}