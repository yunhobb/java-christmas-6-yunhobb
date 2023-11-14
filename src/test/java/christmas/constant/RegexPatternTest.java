package christmas.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RegexPattern의")
class RegexPatternTest {

    @DisplayName("숫자 폼에 입력시")
    @Nested
    class Numeric {

        @DisplayName("숫자면 false를 반환하는가")
        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3"})
        void check_with_number(String input) {
            //given & when & then
            assertThat(RegexPattern.isNotNumeric(input)).isFalse();
        }

        @DisplayName("숫자가 아니면 true를 반환하는가")
        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "c"})
        void check_without_number(String input) {
            //given & when & then
            assertThat(RegexPattern.isNotNumeric(input)).isTrue();
        }
    }

    @DisplayName("메뉴 폼에 입력시")
    @Nested
    class OrderFormat {

        @DisplayName("일치하면 false를 반환하는가")
        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"})
        void check_with_number(String input) {
            //given & when & then
            assertThat(RegexPattern.isNotOrderMenuFormat(input)).isFalse();
        }

        @DisplayName("일치하지 않으면 true를 반환하는가")
        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크/1", "티본스테이크//1", "티본스테이크--1"})
        void check_without_number(String input) {
            //given & when & then
            assertThat(RegexPattern.isNotOrderMenuFormat(input)).isTrue();
        }
    }
}
