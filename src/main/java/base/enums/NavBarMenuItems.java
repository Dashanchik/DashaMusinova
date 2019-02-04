package base.enums;

public enum NavBarMenuItems {
    /* TODO - fixed
        Please try provide more convenient names for the enums.
        From the test it is not clear what do you mean under HOME or CONTACT
     */
    HOME("HOME"),
    CONTACT("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    private String value;

    NavBarMenuItems(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
