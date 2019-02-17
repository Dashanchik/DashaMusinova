package base.enums;

public enum ServiceMenuItems {
    //TODO - change table for tables with pages - it's TABLE WITH PAGES on GUI, if change it to TABLES test will fail
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    public final String value;

    ServiceMenuItems(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ServiceMenuItems getServiceMenuItemByTheName(String menuItem){
        for(ServiceMenuItems item: values()){
            if(item.toString().equals(menuItem)){
                return item;
            }
        }
        throw new IllegalArgumentException("Wrong Service menu item name");
    }
}