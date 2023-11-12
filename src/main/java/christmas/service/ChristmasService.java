package christmas.service;

import christmas.domain.OrderManager;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.domain.TotalDiscount;
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

    public OrderManager managing() {
        final OrderMenu orderMenu = domainRepository.getOrderMenu();
        final OrderManager orderManager = new OrderManager(orderMenu);
        domainRepository.saveOrderManager(orderManager);
        return orderManager;
    }

    public void calculateOrderPrice() {
        final OrderManager orderManager = domainRepository.getOrderManager();
        final TotalOrderPrice totalOrderPrice = orderManager.getTotalOrderPrice();
        domainRepository.saveTotalOrderPrice(totalOrderPrice);
    }

    public void calculateTotalDiscount() {
        final ReservationDate reservationDate = domainRepository.getReservationDate();
        final OrderManager orderManager = domainRepository.getOrderManager();
        final TotalDiscount totalDiscount = new TotalDiscount(reservationDate, orderManager);
        domainRepository.saveTotalDiscount(totalDiscount);

    }
}
