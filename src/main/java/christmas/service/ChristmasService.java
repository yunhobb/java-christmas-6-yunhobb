package christmas.service;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalDiscount;
import christmas.domain.TotalOrderPrice;
import christmas.repository.DomainRepository;

public class ChristmasService {

    private final DomainRepository domainRepository;

    public ChristmasService(final DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public void saveReservationDate(final ReservationDate reservationDate) {
        domainRepository.saveReservationDate(reservationDate);
    }

    public void saveOrderMenu(final OrderMenu orderMenu) {
        domainRepository.saveOrderMenu(orderMenu);
    }

    public void managing() {
        final OrderMenu orderMenu = domainRepository.getOrderMenu();
        final OrderManager orderManager = new OrderManager(orderMenu);
        domainRepository.saveOrderManager(orderManager);
    }

    public TotalOrderPrice calculateOrderPrice() {
        final OrderManager orderManager = domainRepository.getOrderManager();
        return orderManager.getTotalOrderPrice();
    }

    public TotalDiscount calculateTotalDiscount() {
        final ReservationDate reservationDate = domainRepository.getReservationDate();
        final OrderManager orderManager = domainRepository.getOrderManager();
        return new TotalDiscount(reservationDate, orderManager);
    }
}
