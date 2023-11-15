package christmas.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ChristmasMenu의")
class ChristmasMenuTest {

    @DisplayName("메뉴 요청시")
    @Nested
    class to_menu {

        @DisplayName("매뉴가 있으면 false가 반환되는가")
        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"})
        void include_menu(String menu) {
            //given & when & then
            assertThat(ChristmasMenu.isNotIncludeMenu(menu)).isFalse();
        }

        @DisplayName("메뉴가 없으면 true가 반환되는가")
        @ParameterizedTest
        @ValueSource(strings = {"된장찌개", "김치찌개", "밥"})
        void not_include_menu(String menu) {
            //given & when & then
            assertThat(ChristmasMenu.isNotIncludeMenu(menu)).isTrue();
        }

        @DisplayName("음료 요청시")
        @Nested
        class to_drink {

            @DisplayName("음료가 있으면 true가 반환되는가")
            void include_drink() {
                //given
                Map<String, Integer> menuWithCount = Map.of("제로콜라", 1,
                        "레드와인", 1,
                        "스테이크", 1);

                // when & then
                assertThat(ChristmasMenu.isAllDrink(menuWithCount)).isTrue();
            }

            @DisplayName("음료가 없으면 false가 반환되는가")
            @Test
            void not_include_drink() {
                //given
                Map<String, Integer> menuWithCount = Map.of("아이스크림", 1,
                        "초코케이크", 1,
                        "스테이크", 1);

                // & when & then
                assertThat(ChristmasMenu.isAllDrink(menuWithCount)).isFalse();
            }
        }
    }
}
