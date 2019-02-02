package base.enums;

public enum NavBarMenuItems {
    FIRST_ITEM("HOME"),
    SECOND_ITEM("CONTACT FORM"),
    THIRD_ITEM("SERVICE"),
    FOURTH_ITEM("METALS & COLORS");

    private String value;

    NavBarMenuItems(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
