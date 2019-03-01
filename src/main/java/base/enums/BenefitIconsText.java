package base.enums;

public enum BenefitIconsText {
    PRACTICE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM("To be flexible and\ncustomizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public final String iconText;

    BenefitIconsText(String iconText) {
        this.iconText = iconText;
    }

    @Override
    public String toString() {
        return iconText;
    }

    public static BenefitIconsText getIconTextByString(String iconText) throws IllegalArgumentException{
        for (BenefitIconsText text: BenefitIconsText.values()){
            if(text.toString().equals(iconText)){
                return text;
            }
        }
        throw new IllegalArgumentException("Wrong icon text");
    }
}
