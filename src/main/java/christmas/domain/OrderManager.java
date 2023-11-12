package christmas.domain;

import christmas.constant.ChristmasMenu;
import java.util.EnumMap;
import java.util.Map;

public class OrderManager {


    private static final Integer DEFAULT_COUNT = 0;
    private final EnumMap<ChristmasMenu, Integer> elements = new EnumMap<>(ChristmasMenu.class);

    public OrderManager(final OrderMenu orderMenu) {
        Map<String, Integer> menuWithCount = orderMenu.getMenuWithCount();
        for (ChristmasMenu value : ChristmasMenu.values()) {
            this.elements.put(value, menuWithCount.getOrDefault(value.getMenuName(), DEFAULT_COUNT));
        }
    }

    public TotalOrderPrice getTotalOrderPrice() {
        int totalPrice = 0;
        for (ChristmasMenu christmasMenu : elements.keySet()) {
            Integer menuPrice = christmasMenu.getPrice();
            totalPrice = totalPrice + menuPrice * elements.get(christmasMenu);
        }
        return new TotalOrderPrice(totalPrice);
    }

    public Integer getDiscountMenuCount(final ReservationDate reservationDate) {
        int count = 0;
        if (reservationDate.isHoliday()) {
            for (ChristmasMenu christmasMenu : elements.keySet()) {
                if (ChristmasMenu.isMain(christmasMenu.getMenuName())) {
                    count = count + elements.get(christmasMenu);
                }
            }
        }
        if (!reservationDate.isHoliday()) {
            for (ChristmasMenu christmasMenu : elements.keySet()) {
                if (ChristmasMenu.isDessert(christmasMenu.getMenuName())) {
                    count = count + elements.get(christmasMenu);
                }
            }
        }
        return count;
    }
}
