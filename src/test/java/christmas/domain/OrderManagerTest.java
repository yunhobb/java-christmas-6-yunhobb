package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OrderManager의")
class OrderManagerTest {

    @DisplayName("총 주문 금액을 가져오는가")
    @Test
    void get_total_order_price() {
        //given
        List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);
        final OrderManager orderManager = new OrderManager(orderMenu);

        final TotalOrderPrice expectedTotalOrderPrice = new TotalOrderPrice(142_000);

        //when
        final TotalOrderPrice actualTotalOrderPrice = orderManager.getTotalOrderPrice();

        //then
        assertThat(actualTotalOrderPrice.toPrice()).isEqualTo(expectedTotalOrderPrice.toPrice());
    }

    @DisplayName("할인을 하는 메뉴의 수량을 반환하는가")
    @Test
    void get_discount_menu_count() {
        //given
        List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(elements);
        final OrderManager orderManager = new OrderManager(orderMenu);

        final ReservationDate reservationDate = new ReservationDate(1);

        //when
        final Integer actualMenuCount = orderManager.getDiscountMenuCount(reservationDate);

        //then
        assertThat(actualMenuCount).isEqualTo(2);
    }
}