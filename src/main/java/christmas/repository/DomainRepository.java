package christmas.repository;

import christmas.constant.ExceptionMessage;
import christmas.domain.ExpectedDate;
import java.util.Optional;
import java.util.function.Supplier;

public class DomainRepository {

    private ExpectedDate expectedDate;

    public void saveExpectedDate(final ExpectedDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(
                        () -> new IllegalStateException(ExceptionMessage.NOT_INITIALIZED.toMessage()));
    }

}
