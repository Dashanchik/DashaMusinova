package base.enums;

public enum Headers {
    // TODO I don't think that enum Header is right place for the Page title value
    PAGE_TITLE("Home Page"),
    MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    TEXT_UNDER_HEADER("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER("JDI GITHUB");

    public final String value;

    Headers(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
