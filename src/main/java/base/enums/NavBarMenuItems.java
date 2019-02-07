package base.enums;

public enum NavBarMenuItems {
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
