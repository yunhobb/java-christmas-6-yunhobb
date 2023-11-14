package christmas.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DomainRepository의")
class DomainRepositoryTest {

    private final DomainRepository domainRepository = new DomainRepository();

    @DisplayName("예약 날짜 저장후 조회가 되는가")
    @Test
    void save_and_get_reservation_date() {
        //given
        final ReservationDate expected = new ReservationDate(1);

        //when
        domainRepository.saveReservationDate(expected);
        final ReservationDate actualReservationDate = domainRepository.getReservationDate();

        //then
        assertThat(actualReservationDate).isEqualTo(expected);
    }

    @DisplayName("주문메뉴 저장후 조회가 되는가")
    @Test
    void save_and_get_order_menu() {
        //given
        final OrderMenu expected = new OrderMenu(
                                            List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));

        //when
        domainRepository.saveOrderMenu(expected);
        final OrderMenu actualOrderMenu = domainRepository.getOrderMenu();

        //then
        assertThat(actualOrderMenu).isEqualTo(expected);
    }

    @DisplayName("주문 매니징 저장후 조회가 되는가")
    @Test
    void save_and_get_order_manager() {
        //given
        List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1");
        final OrderMenu orderMenu = new OrderMenu(
                                        List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));
        final OrderManager expected = new OrderManager(orderMenu);

        //when
        domainRepository.saveOrderManager(expected);
        final OrderManager actualOrderManager = domainRepository.getOrderManager();

        //then
        assertThat(actualOrderManager).isEqualTo(expected);
    }

    @DisplayName("저장없이 조회하면 예외를 던지는가")
    @Test
    void getWithoutSave() {
        // given
        // when
        // then
        assertThatThrownBy(domainRepository::getReservationDate)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(domainRepository::getOrderMenu)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(domainRepository::getOrderManager)
                .isInstanceOf(IllegalStateException.class);
    }
}