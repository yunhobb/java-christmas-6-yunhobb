package christmas.constant;

public enum MenuCategory {
    APPETIZER("appetizer"),
    MAIN("main"),
    DESSERT("dessert"),
    DRINK("drink"),
    NONE("none");

    private final String course;

    MenuCategory(final String course) {
        this.course = course;
    }

    public String toCourse() {
        return this.course;
    }
}
