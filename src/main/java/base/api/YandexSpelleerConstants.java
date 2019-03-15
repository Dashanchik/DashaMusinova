package base.api;

public class YandexSpelleerConstants {

    //todo для учебного проекта - +/- номально, что полный урл в коде, но на практичке - нужно выность
    //todo в проперти https://speller.yandex.net/ название энва, т.к. оно может меняться, а управлятьнамного проще из внешнего файла
    //todo будет время - поправь, пожалуйста ***пожелания***
    //todo  static final String YANDEX_SPELLER_API_URI = services/spellservice.json/checkTexts";
    static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkTexts";
    static final String PARAM_TEXTS = "text";
    static final String PARAM_OPTIONS = "options";
    static final String PARAM_LANGUAGES = "languages";

    //todo хорошо, что есть енамы, но этот енам не для уровняобвязок. Это на уровень тестов больше похоже,
    // todo более того - на уровень одного датапровайдера ***замечания***
    public enum SimpleWord {
        MINUTE_RU("минута", "минутта"),
        HOUR_RU("час", "ччас"),
        MINUTE_UK("хвилина", "хвиллина"),
        HOUR_UK("година", "годиина"),
        MINUTE_EN("minute", "minuute"),
        HOUR_EN("hour", "houur"),
        URL("google.com", "google"),
        WORD_WITH_CAPITALS("word", "wOrD"),
        REPEAT_WORD("на", "Едем на на юг!"),
        UNKNOWN_WORD("sdsdffd", "sdsdffd");

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
