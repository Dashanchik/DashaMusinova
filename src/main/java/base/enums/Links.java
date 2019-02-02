package base.enums;

public enum Links {
    INDEX_PAGE("https://epam.github.io/JDI/index.html"),
    JDI_GITHUB("https://github.com/epam/JDI");

    public final String value;

    Links(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
