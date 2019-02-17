package base.enums;

public enum CheckboxesLabels {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public final String value;

    CheckboxesLabels(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static CheckboxesLabels getCheckboxByTheName(String checkboxName) throws IllegalArgumentException{
        for (CheckboxesLabels label : values()) {
            if (label.toString().equals(checkboxName)) {
                return label;
            }
        }
        throw new IllegalArgumentException("Wrong Checkbox name");
    }
}

