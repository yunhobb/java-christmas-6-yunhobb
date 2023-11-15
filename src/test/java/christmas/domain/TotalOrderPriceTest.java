package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TotalOrderPrice의")
class TotalOrderPriceTest {

    @DisplayName("최종 지불 금액을 반환 하는가")
    @Test
    void get_total_price() {
        //given
        final TotalOrderPrice totalOrderPrice = new TotalOrderPrice(24_000);

        final ReservationDate reservationDate = new ReservationDate(1);
        final List<String> elements = List.of("시저셀러드-3");
        final OrderMenu orderMenu = new OrderMenu(elements);
        final OrderManager orderManager = new OrderManager(orderMenu);
        final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

        final Integer expectedTotalPrice = 23_000;
        //when & then
        assertThat(totalOrderPrice.getTotalPrice(totalDiscount)).isEqualTo(expectedTotalPrice);
    }

    @DisplayName("샴페인 이벤트 검증시")
    @Nested
    class GiveawayEvent {

        @DisplayName("샴페인을 받는가")
        @Test
        void get_giveaway() {
            //given
            final TotalOrderPrice totalOrderPrice = new TotalOrderPrice(120_000);

            //when & then
            assertThat(totalOrderPrice.checkGiveawayEvent()).isTrue();
        }

        @DisplayName("샴페인을 못받는가")
        @Test
        void not_get_giveaway() {
            //given
            final TotalOrderPrice totalOrderPrice = new TotalOrderPrice(100_000);

            //when & then
            assertThat(totalOrderPrice.checkGiveawayEvent()).isFalse();
        }
    }
}