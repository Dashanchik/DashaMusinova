package api.hw8;

import static base.api.YandexSpellerApiTexts.ApiBuilder.*;
import static base.api.YandexSpellerAssertions.*;

import base.api.YandexSpellerConstants.Languages;
import base.api.YandexSpellerConstants.SimpleWord;
import base.api.YandexSpellerDataProvider;
import base.api.beans.YandexSpellerAnswer;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;
//todo постарайся разгруппировать по сьюттам, тестов не очень много, но все-таки так будет наглянее - done

//todo у тебя к каждом тесте проврок куча! это и хорошо и плохо одновременно)) не всегда оправдано.
//todo постарайся сформировать готовые объекты (листы) для проверок, чтобы асер был один, но компдектный
//todo, например, для некоторый кейсов сделай так
// List<YandexSpellerAnswer> expectedAnswer = ....;
// List<YandexSpellerAnswer> actualAnswer = ....;
// assertEqual(actualAnswer, expectedAnswer, "Answer is incorrect");
public class YandexSpellerTextsTest {

    @Test(groups = "statusCodes")
    public void checkStatusCodeSuccess() {
        RestAssured
                .given(baseRequestConfiguration())//todo не стесняйся использовать статический импорт - так читабельнее - done
                .get()//todo .prettyPeek() в этом нет необходимости - deleted
                .then().specification(successResponse());
    }

    //todo checkSpellingEnglishWords, checkSpellingRussianWords, checkSpellingUkranianWords - done
    //todo тут один сценарий и незачем его кописровать - просто используй DataProvider - done
    @Test(groups = "spelling", dataProvider = "yandexSpellerData", dataProviderClass = YandexSpellerDataProvider.class)
    public void checkSpellingForOneLanguage(Languages language, String[] wrongWords, String[] correctWords) {
        List<YandexSpellerAnswer> answers =
                getYandexSpellerAnswers(with()
                        .languages(language)
                            .texts(wrongWords)
                        .getYandexSpellerApi());
        assertAnswerSize(answers, correctWords.length);
        assertAnswersIsCorrect(answers, correctWords);
    }

        //todo "Unswers number is not correct." - done
        //todo сильно много, где встречается. лучше спрятать это в отдельный класс с асертами и назвать метод, например, assertAnswerSize(answer, 2); - done
        //todo комментарий аналогичный - done

    @Test(groups = "spelling")
    public void checkSpellingAllLanguages() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.UK, Languages.EN, Languages.RU)
                        .texts(SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.MINUTE_RU.wrongVer())
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 3);
        assertAnswerIsCorrect(answer,0,SimpleWord.MINUTE_UK.corrVer());
        assertAnswerIsCorrect(answer,1,SimpleWord.MINUTE_EN.corrVer());
        assertAnswerIsCorrect(answer,2,SimpleWord.MINUTE_RU.corrVer());
    }

    //Test fails
    @Test(groups = "errorCodes")
    public void checkUnknownWordError() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.UNKNOWN_WORD.wrongVer())
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 1);
        assertErrorCodeIsCorrect(answer, 0, 1);
    }

    @Test(groups = "options")
    public void checkIgnoreDigitsOption() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2)
                        .texts(SimpleWord.MINUTE_EN.corrVer() + "123")
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 0);
    }

    @Test(groups = "errorCodes")
    public void checkDigitsError() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.MINUTE_EN.corrVer() + "123")
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 1);
        assertAnswerIsCorrect(answer, 0, SimpleWord.MINUTE_EN.corrVer() + " " + "123");
        assertErrorCodeIsCorrect(answer, 0, 1);
    }

    @Test(groups = "options")
    public void checkIgnoreUrlsAndDigitsOption() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2, 4)
                        .texts(SimpleWord.URL.wrongVer() + "555")
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 0);
    }

    //Test fails
    @Test(groups = "errorCodes")
    public void checkCapitalLettersError() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.WORD_WITH_CAPITALS.wrongVer())
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 1);
        assertErrorCodeIsCorrect(answer, 0, 3);
    }

    @Test(groups = "options")
    public void checkIgnoreCapitalLettersAndDigitsOption() {
        List<YandexSpellerAnswer> answer =
                //todo разнеси по разным класса формаорование запроса и его исполнение
                //todo getYandexSpellerAnswers & with должны быть в разных классах
                getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2, 4, 512)
                        .texts(SimpleWord.WORD_WITH_CAPITALS.wrongVer())
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 0);
    }

    @Test(groups = "options")
    public void checkFindRepeatWordsOption() {
        List<YandexSpellerAnswer> answer =
                getYandexSpellerAnswers(with()
                        .languages(Languages.RU)
                        .options(512)
                        .texts(SimpleWord.REPEAT_WORD.wrongVer())
                        .getYandexSpellerApi());
        assertAnswerSize(answer, 0);
    }
}
