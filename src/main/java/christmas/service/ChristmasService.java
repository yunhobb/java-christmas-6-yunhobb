package christmas.service;

import christmas.domain.ReservationDate;
import christmas.repository.DomainRepository;

public class ChristmasService {

    private final DomainRepository domainRepository;

    public ChristmasService() {
        this.domainRepository = new DomainRepository();
    }

    public void saveReservationDate(final ReservationDate reservationDate) {
        domainRepository.saveReservationDate(reservationDate);
    }
}
