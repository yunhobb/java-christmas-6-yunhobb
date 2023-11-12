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

    public TotalPriceBeforeDiscount getTotalPriceBeforeDiscount() {
        Integer totalPrice = 0;
        for (ChristmasMenu christmasMenu : elements.keySet()) {
            Integer menuPrice = christmasMenu.getPrice();
            totalPrice = totalPrice + menuPrice * elements.get(christmasMenu);
        }
        return new TotalPriceBeforeDiscount(totalPrice);
    }
}
