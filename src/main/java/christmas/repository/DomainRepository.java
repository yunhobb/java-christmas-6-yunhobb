package christmas.repository;

import christmas.constant.ExceptionMessage;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import java.util.Optional;
import java.util.function.Supplier;

public class DomainRepository {

    private ReservationDate reservationDate;
    private OrderMenu orderMenu;

    public void saveReservationDate(final ReservationDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void saveOrderMenu(final OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(
                        () -> new IllegalStateException(ExceptionMessage.NOT_INITIALIZED.toMessage()));
    }

}
