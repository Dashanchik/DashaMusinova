package base.enums;

public enum RadioControls {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public final String value;

    RadioControls(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
