package christmas.constant;

import java.util.Arrays;

public enum Badge {
    STAR("별", 20_000),
    TREE("트리", 10_000),
    SANTA("산타", 5_000),
    NONE("없음", 0);

    private final String name;
    private final Integer target;


    Badge(final String name, final Integer target) {
        this.name = name;
        this.target = target;
    }

    public static Badge getBadge(final Integer price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> price >= badge.target)
                .findFirst()
                .orElse(Badge.NONE);
    }

    public String toName() {
        return name;
    }
}
