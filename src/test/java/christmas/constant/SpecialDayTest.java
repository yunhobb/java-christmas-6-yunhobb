package christmas.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("SpecialDay의")
class SpecialDayTest {

    @DisplayName("special day가 일치하면 true를 반환하는가")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void check_special_day(Integer day) {
        // given & when & then
        assertThat(SpecialDay.isSpecialDay(day)).isTrue();
    }

    @DisplayName("special day가 일치하지않으면 false를 반환하는가")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 11, 26, 30})
    void check_non_special_day(Integer day) {
        // given & when & then
        assertThat(SpecialDay.isSpecialDay(day)).isFalse();
    }
}
