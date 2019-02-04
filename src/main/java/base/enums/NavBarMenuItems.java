package base.enums;

public enum NavBarMenuItems {
    /* TODO
        Please try provide more convenient names for the enums.
        From the test it is not clear what do you mean under FIRST_ITEM or SECOND_ITEM
     */
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
