package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("TotalDiscount의")
class TotalDiscountTest {

    @DisplayName("TotalDiscount 객체가 생성시")
    @Nested
    class NewTotalDiscount {

        @DisplayName("총 주문 금액이 10000원 이상이면 할인이 적용 되는가")
        @Test
        void apply_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(1);
            final List<String> elements = List.of("시저셀러드-3");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);

            //when
            final TotalDiscount actualTotalDiscount = new TotalDiscount(reservationDate, orderManager);

            //then
            assertThat(actualTotalDiscount.getDayDiscount()).isNotZero();
        }

        @DisplayName("총 주문 금액이 10000원 이하면 할인이 적용 안되는가")
        @Test
        void do_not_apply_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(1);
            final List<String> elements = List.of("시저셀러드-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);

            //when
            final TotalDiscount actualTotalDiscount = new TotalDiscount(reservationDate, orderManager);

            //then
            assertThat(actualTotalDiscount.getDayDiscount()).isZero();
        }
    }


    @DisplayName("일자 할인이")
    @Nested
    class DayEvent {

        @DisplayName("적용 되었는가")
        @Test
        void is_day_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(1);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotDayDiscount()).isTrue();
        }

        @DisplayName("적용 안되었는가")
        @Test
        void is_not_day_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(31);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotDayDiscount()).isFalse();
        }
    }

    @DisplayName("요일 할인이")
    @Nested
    class WeekendEvent {

        @DisplayName("적용 되었는가")
        @Test
        void is_weekend_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(7);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotWeekendDiscount()).isTrue();
        }

        @DisplayName("적용 안되었는가")
        @Test
        void is_not_weekend_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(5);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotWeekendDiscount()).isFalse();
        }
    }

    @DisplayName("특별 할인이")
    @Nested
    class SpecialEvent {

        @DisplayName("적용 되었는가")
        @Test
        void is_special_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(3);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotSpecialDiscount()).isTrue();
        }

        @DisplayName("적용 안되었는가")
        @Test
        void is_not_special_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(5);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);

            //when & then
            assertThat(totalDiscount.isNotSpecialDiscount()).isFalse();
        }
    }

    @DisplayName("할인값 검증시")
    @Nested
    class CheckTotalDiscount {

        @DisplayName("최종 할인값 증정품과 반환하는가")
        @Test
        void get_total_discount_with_total_price_with_giveaway() {
            //given
            final ReservationDate reservationDate = new ReservationDate(3);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);
            final TotalOrderPrice totalOrderPrice = new TotalOrderPrice(167_000);
            final Integer expectedDiscountPrice = 31_246;

            //when
            final Integer actualDiscountPrice = totalDiscount.getTotalDiscountWithTotalPrice(totalOrderPrice);

            //then
            assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
        }

        @DisplayName("최종 할인값을 증정품 없이 반환하는가")
        @Test
        void get_total_discount_with_total_price_without_giveaway() {
            //given
            final ReservationDate reservationDate = new ReservationDate(3);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);
            final TotalOrderPrice totalOrderPrice = new TotalOrderPrice(109_000);
            final Integer expectedDiscountPrice = 2_200;

            //when
            final Integer actualDiscountPrice = totalDiscount.getTotalDiscountWithTotalPrice(totalOrderPrice);

            //then
            assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
        }

        @DisplayName("최종 반환 할인값 반환하는가")
        @Test
        void get_total_discount() {
            //given
            final ReservationDate reservationDate = new ReservationDate(3);
            final List<String> elements = List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
            final OrderMenu orderMenu = new OrderMenu(elements);
            final OrderManager orderManager = new OrderManager(orderMenu);
            final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);
            final Integer expectedDiscountPrice = 6_246;

            //when
            final Integer actualDiscountPrice = totalDiscount.getTotalDiscount();

            //then
            assertThat(actualDiscountPrice).isEqualTo(expectedDiscountPrice);
        }
    }
}
