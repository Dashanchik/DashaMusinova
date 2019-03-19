package base.api;

public class YandexSpellerConstants {

    //todo для учебного проекта - +/- номально, что полный урл в коде, но на практичке - нужно выность - done
    //todo в проперти https://speller.yandex.net/ название энва, т.к. оно может меняться, а управлятьнамного проще из внешнего файла - done
    //todo будет время - поправь, пожалуйста ***пожелания*** - done
    //todo  static final String YANDEX_SPELLER_API_URI = services/spellservice.json/checkTexts"; - done
    static final String YANDEX_SPELLER_API_URI = "services/spellservice.json/checkTexts";
    static final String PARAM_TEXTS = "text";
    static final String PARAM_OPTIONS = "options";
    static final String PARAM_LANGUAGES = "languages";

    //todo хорошо, что есть енамы, но этот енам не для уровняобвязок. Это на уровень тестов больше похоже,
    //todo более того - на уровень одного датапровайдера ***замечания*** - done, enum deleted

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
