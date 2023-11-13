package christmas.repository;

import christmas.constant.ExceptionMessage;
import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import java.util.Optional;
import java.util.function.Supplier;

public class DomainRepository {

    private ReservationDate reservationDate;
    private OrderMenu orderMenu;
    private OrderManager orderManager;

    public void saveReservationDate(final ReservationDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationDate getReservationDate() {
        return get(() -> this.reservationDate);
    }

    public void saveOrderMenu(final OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
    }

    public OrderMenu getOrderMenu() {
        return get(() -> this.orderMenu);
    }

    public void saveOrderManager(final OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public OrderManager getOrderManager() {
        return get(() -> this.orderManager);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(
                        () -> new IllegalStateException(ExceptionMessage.NOT_INITIALIZED.toMessage()));
    }
}
