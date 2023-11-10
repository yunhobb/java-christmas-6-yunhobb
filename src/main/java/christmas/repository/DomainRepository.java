package christmas.repository;

import christmas.constant.ExceptionMessage;
import christmas.domain.ReservationDate;
import java.util.Optional;
import java.util.function.Supplier;

public class DomainRepository {

    private ReservationDate reservationDate;

    public void saveReservationDate(final ReservationDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(
                        () -> new IllegalStateException(ExceptionMessage.NOT_INITIALIZED.toMessage()));
    }

}
