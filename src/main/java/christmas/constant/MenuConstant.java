package christmas.constant;

public enum MenuConstant {
    APPETIZER("appetizer"),
    MAIN("main"),
    DESSERT("dessert"),
    DRINK("drink");

    private final String course;

    MenuConstant(final String course) {
        this.course = course;
    }

    public String toCourse() {
        return this.course;
    }
}