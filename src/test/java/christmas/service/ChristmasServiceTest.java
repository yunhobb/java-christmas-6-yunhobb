package christmas.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalDiscount;
import christmas.repository.DomainRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ChristmasService의")
class ChristmasServiceTest {

    private final DomainRepository domainRepository = new DomainRepository();
    private final ChristmasService christmasService = new ChristmasService(domainRepository);

    @DisplayName("예약날짜가 저장이 되는가")
    @Test
    void save_reservation_date() {
        //given
        final ReservationDate expected = new ReservationDate(1);

        //when
        christmasService.saveReservationDate(expected);

        //then
        assertThat(domainRepository.getReservationDate()).isEqualTo(expected);
    }


    @DisplayName("주문 매니징이 되는가")
    @Test
    void managing() {
        //given
        final OrderMenu orderMenu = new OrderMenu(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
        domainRepository.saveOrderMenu(orderMenu);
        final OrderManager expected = new OrderManager(orderMenu);

        //when
        christmasService.managing();

        //then
        assertThat(domainRepository.getOrderManager().getTotalOrderPrice().toPrice())
                .isEqualTo(expected.getTotalOrderPrice().toPrice());

    }

    @DisplayName("총 주문값이 반환되는가")
    @Test
    void calculate_order_price() {
        //given
        final OrderMenu orderMenu = new OrderMenu(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
        domainRepository.saveOrderMenu(orderMenu);
        final OrderManager expected = new OrderManager(orderMenu);
        domainRepository.saveOrderManager(expected);

        //when & then
        assertThat(christmasService.calculateOrderPrice().toPrice())
                .isEqualTo(expected.getTotalOrderPrice().toPrice());
    }

    @DisplayName("총 할인값이 반환되는가")
    @Test
    void calculate_total_discount() {
        //given
        final ReservationDate reservationDate = new ReservationDate(1);
        domainRepository.saveReservationDate(reservationDate);
        final OrderMenu orderMenu = new OrderMenu(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
        final OrderManager orderManager = new OrderManager(orderMenu);
        domainRepository.saveOrderManager(orderManager);
        final TotalDiscount expected = new TotalDiscount(reservationDate, orderManager);

        //when & then
        assertThat(christmasService.calculateTotalDiscount().getTotalDiscount())
                .isEqualTo(expected.getTotalDiscount());
    }
}