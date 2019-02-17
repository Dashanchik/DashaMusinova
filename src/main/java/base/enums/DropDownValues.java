package base.enums;

public enum DropDownValues {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");


    public final String value;

    DropDownValues(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static DropDownValues getDropDownByTheName(String dropDownName){
        for (DropDownValues dropDown: values()){
            if(dropDown.toString().equals(dropDownName)){
                return dropDown;
            }
        }
        throw new IllegalArgumentException("Wrong Dropdown item name");
    }
}
