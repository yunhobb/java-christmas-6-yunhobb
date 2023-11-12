package christmas.domain;

import christmas.constant.ChristmasMenu;
import java.util.EnumMap;
import java.util.Map;

public class OrderManager {


    private static final Integer DEFAULT_COUNT = 0;
    private final EnumMap<ChristmasMenu, Integer> elements = new EnumMap<>(ChristmasMenu.class);

    public OrderManager(final OrderMenu orderMenu) {
        initElements();
        Map<String, Integer> menuWithCount = orderMenu.getMenuWithCount();
        for (ChristmasMenu value : ChristmasMenu.values()) {
            this.elements.put(value, menuWithCount.get(value));
        }
    }

    private void initElements() {
        for (ChristmasMenu value : ChristmasMenu.values()) {
            elements.put(value, DEFAULT_COUNT);
        }
    }


}
