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

    public static RadioControls getRadioControlByTheName(String radioName) {
        for (RadioControls radioControl : values()) {
            if (radioControl.toString().equals(radioName)) {
                return radioControl;
            }
        }
        throw new IllegalArgumentException("Wrong Radio Control name");
    }
}
