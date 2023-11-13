package christmas.domain;

import christmas.constant.ChristmasMenu;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

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
        Predicate<ChristmasMenu> filter = menu -> true;
        if (reservationDate.isHoliday()) {
            filter = menu -> ChristmasMenu.isMain(menu.getMenuName());
        }
        if (!reservationDate.isHoliday()) {
            filter = menu -> ChristmasMenu.isDessert(menu.getMenuName());
        }
        return getFilteredMenuCount(filter);
    }

    private Integer getFilteredMenuCount(Predicate<ChristmasMenu> filter) {
        return elements.entrySet().stream()
                .filter(entry -> filter.test(entry.getKey()))
                .mapToInt(Entry::getValue)
                .sum();
    }
}
