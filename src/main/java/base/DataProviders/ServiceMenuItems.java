package base.DataProviders;

public enum ServiceMenuItems {
    //TODO - change table for tables with pages - it's TABLE WITH PAGES on GUI, if change it to TABLES test will fail
    // TODO Why is it not enum? - changed to enum - fixed
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
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
}