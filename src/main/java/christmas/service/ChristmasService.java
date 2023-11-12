package christmas.service;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalOrderPrice;
import christmas.repository.DomainRepository;

public class ChristmasService {

    private final DomainRepository domainRepository;

    public ChristmasService() {
        this.domainRepository = new DomainRepository();
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

    public void calculate() {
        final OrderManager orderManager = domainRepository.getOrderManager();
        final TotalOrderPrice totalOrderPrice = orderManager.getTotalPriceBeforeDiscount();
        domainRepository.saveTotalPriceBeforeDiscount(totalOrderPrice);
    }
}
