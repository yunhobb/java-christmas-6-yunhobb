package christmas.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputMapper의")
class InputMapperTest {

    final InputMapper inputMapper = new InputMapper();

    @DisplayName("예약날짜로 반환 되는가")
    @Test
    void to_reservation_date() {
        //given
        final String input = "1";

        //when
        final ReservationDate reservationDate = inputMapper.toReservationDate(input);

        //then
        assertThat(reservationDate.getDay()).isEqualTo(1);
    }

    @DisplayName("주문 메뉴로 반환 되는가")
    @Test
    void to_order_menu() {
        //given
        final String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        //when
        final OrderMenu orderMenu = inputMapper.toOrderMenu(input);

        //then
        assertThat(orderMenu.getMenuWithCount().size()).isEqualTo(4);
    }
}