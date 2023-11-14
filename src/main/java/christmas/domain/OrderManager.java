package christmas.domain;

import christmas.constant.ChristmasMenu;
import christmas.constant.MenuCategory;
import java.util.EnumMap;
import java.util.Map;

public class OrderManager {


    private static final int DEFAULT_COUNT = 0;
    private final EnumMap<ChristmasMenu, Integer> elements = new EnumMap<>(ChristmasMenu.class);

    public OrderManager(final OrderMenu orderMenu) {
        Map<String, Integer> menuWithCount = orderMenu.getMenuWithCount();
        for (ChristmasMenu value : ChristmasMenu.values()) {
            this.elements.put(value, menuWithCount.getOrDefault(value.getMenuName(), DEFAULT_COUNT));
        }
    }

    public TotalOrderPrice getTotalOrderPrice() {
        Integer totalPrice = elements.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return new TotalOrderPrice(totalPrice);
    }

    public Integer getDiscountMenuCount(final ReservationDate reservationDate) {
        MenuCategory filterConstant = MenuCategory.NONE;
        if (reservationDate.isHoliday()) {
            filterConstant = MenuCategory.MAIN;
        }
        if (!reservationDate.isHoliday()) {
            filterConstant = MenuCategory.DESSERT;
        }
        return getFilteredMenuCount(filterConstant);
    }

    private Integer getFilteredMenuCount(final MenuCategory menuCategory) {
        return elements.entrySet().stream()
                .filter(entry -> entry.getKey().getCourse() == menuCategory)
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum);
    }
}
