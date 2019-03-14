package base.api;

public class YandexSpelleerConstants {

    static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkTexts";
    static final String PARAM_TEXTS = "text";
    static final String PARAM_OPTIONS = "options";
    static final String PARAM_LANGUAGES = "languages";

    public enum SimpleWord {
        MINUTE_RU("минута", "минутта"),
        HOUR_RU("час", "ччас"),
        MINUTE_UK("хвилина", "хвиллина"),
        HOUR_UK("година", "годиина"),
        MINUTE_EN("minute", "minuute"),
        HOUR_EN("hour","houur"),
        URL("google.com","google"),
        WORD_WITH_CAPITALS("word","wOrD"),
        REPEAT_WORD("на", "Едем на на юг!"),
        UNKNOWN_WORD("sdsdffd","sdsdffd");

        private String corrVer;
        private String wrongVer;

        public String corrVer() {
            return corrVer;
        }

        public String wrongVer() {
            return wrongVer;
        }

        SimpleWord(String corrVer, String wrongVer) {
            this.corrVer = corrVer;
            this.wrongVer = wrongVer;
        }
    }

    public enum Languages {
        EN("en"),
        RU("ru"),
        UK("uk");

        private final String lang;

        Languages(String lang) {
            this.lang = lang;
        }

        public String getLang() {
            return lang;
        }
    }
}
