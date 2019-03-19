package api.hw8;

import static base.api.YandexSpellerApiTexts.ApiBuilder.*;
import static base.api.YandexSpellerAssertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

import base.api.YandexSpellerApiGetter;
import base.api.YandexSpellerConstants.Languages;
import base.api.YandexSpellerDataProvider;
import base.api.beans.YandexSpellerAnswer;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.*;
//todo постарайся разгруппировать по сьюттам, тестов не очень много, но все-таки так будет наглянее - done

//todo у тебя к каждом тесте проврок куча! это и хорошо и плохо одновременно)) не всегда оправдано.
//todo постарайся сформировать готовые объекты (листы) для проверок, чтобы асер был один, но компдектный
//todo, например, для некоторый кейсов сделай так
// List<YandexSpellerAnswer> expectedAnswer = ....;
// List<YandexSpellerAnswer> actualAnswer = ....;
// assertEqual(actualAnswer, expectedAnswer, "Answer is incorrect"); - done, see checkDigitsError() and checkDifferentLanguageHints() tests
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
    public void checkSpellingForOneLanguage(Languages[] languages, String[] wrongWords, String[] correctWords) {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(languages)
                        .texts(wrongWords)
                        .getYandexSpellerApi());
        assertAnswerSize(answers, correctWords.length);
        assertAnswersAreCorrect(answers, correctWords);
    }

    //todo "Unswers number is not correct." - done
    //todo сильно много, где встречается. лучше спрятать это в отдельный класс с асертами и назвать метод, например, assertAnswerSize(answer, 2); - done
    //todo комментарий аналогичный - done

    //Test fails
    @Test(groups = "errorCodes")
    public void checkUnknownWordError() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts("sdsdffd")
                        .getYandexSpellerApi());
        YandexSpellerAnswer expectedAnswer = new YandexSpellerAnswer(1, "sdsdffd", Arrays.asList("sdsdffd"));
        assertThat("The answer is wrong", expectedAnswer.equals(answers.get(0)));
        assertAnswerSize(answers, 1);
    }

    @Test(groups = "options")
    public void checkIgnoreDigitsOption() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2)
                        .texts("minute" + "123")
                        .getYandexSpellerApi());
        assertAnswerSize(answers, 0);
    }

    @Test(groups = "errorCodes")
    public void checkDigitsError() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts("minute" + "123")
                        .getYandexSpellerApi());
        YandexSpellerAnswer expectedAnswer = new YandexSpellerAnswer(1, "minute" + "123", Arrays.asList("minute 123", "minutes 123", "minister 123"));
        assertThat("The answer is wrong", expectedAnswer.equals(answers.get(0)));
        assertAnswerSize(answers, 1);
    }

    @Test(groups = "errorCodes")
    public void checkDifferentLanguageHints() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts("яблоняя")
                        .getYandexSpellerApi());
        YandexSpellerAnswer expectedAnswer = new YandexSpellerAnswer(1, "яблоняя", Arrays.asList("яблоня", "яблочная", "яблоная"));
        assertThat("The answer is wrong", expectedAnswer.equals(answers.get(0)));
        assertAnswerSize(answers, 1);
    }

    @Test(groups = "options")
    public void checkIgnoreUrlsAndDigitsOption() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2, 4)
                        .texts("google.com" + "555")
                        .getYandexSpellerApi());
        assertAnswerSize(answers, 0);
    }

    //Test fails
    @Test(groups = "errorCodes")
    public void checkCapitalLettersError() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(0)
                        .texts("wOrD")
                        .getYandexSpellerApi());
        assertAnswerSize(answers, 1);
        assertErrorCodeIsCorrect(answers, 0, 3);
    }

    @Test(groups = "options")
    public void checkIgnoreCapitalLettersAndDigitsOption() {
        List<YandexSpellerAnswer> answers =
                //todo разнеси по разным класса формаорование запроса и его исполнение - done
                //todo getYandexSpellerAnswers & with должны быть в разных классах - done
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.EN)
                        .options(2, 4, 512)
                        .texts("wOrD")
                        .getYandexSpellerApi());
        assertAnswerSize(answers, 0);
    }

    @Test(groups = "options")
    public void checkFindRepeatWordsOption() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApiGetter.getYandexSpellerAnswers(with()
                        .languages(Languages.RU)
                        .options(512)
                        .texts("Едем на на юг!")
                        .getYandexSpellerApi());
        assertAnswerSize(answers, 0);
    }
}
