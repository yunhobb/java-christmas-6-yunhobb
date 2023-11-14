package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OrderMenu의")
class OrderMenuTest {

    @DisplayName("없는 메뉴면 예외를 던지는가")
    @Test
    void validate_non_menu() {
        //given
        final List<String> elements = List.of("김치찌개-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 숫자가 아니면 예외를 던지는가")
    @Test
    void validate_menu_count_numeric() {
        //given
        final List<String> elements = List.of("티본스테이크-a", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴이름이 중복되면 예외를 던지는가")
    @Test
    void validate_duplicate_name() {
        //given
        final List<String> elements = List.of("티본스테이크-1", "티본스테이크-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴개수가 1보다 작으면 예외를 던지는가")
    @Test
    void validate_min_menu_count() {
        //given
        final List<String> elements = List.of("티본스테이크-0", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴개수가 1보다 작으면 예외를 던지는가")
    @Test
    void validate_max_meun_count() {
        //given
        final List<String> elements = List.of("티본스테이크-21", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴개수가 1보다 작으면 예외를 던지는가")
    @Test
    void validate_only_drink_menu() {
        //given
        final List<String> elements = List.of("제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatThrownBy(orderMenu::getMenuWithCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 입력하면 에외를 던지지 않는가")
    @Test
    void normal_output() {
        //given
        final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);

        //when & then
        assertThatNoException()
                .isThrownBy(orderMenu::getMenuWithCount);
    }
}
