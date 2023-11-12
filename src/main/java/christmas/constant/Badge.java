package christmas.constant;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    private final String name;


    Badge(final String name) {
        this.name = name;
    }

    public static Badge getBadge(Integer price) {
        if (price > 20000) {
            return Badge.SANTA;
        }
        if (price > 10000) {
            return Badge.TREE;
        }
        if (price > 5000) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    public String toName() {
        return name;
    }
}
