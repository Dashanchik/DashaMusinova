package base.api;

public class YandexSpellerConstants {

    static final String YANDEX_SPELLER_API_URI = "services/spellservice.json/checkTexts";
    static final String PARAM_TEXTS = "text";
    static final String PARAM_OPTIONS = "options";
    static final String PARAM_LANGUAGES = "languages";

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
