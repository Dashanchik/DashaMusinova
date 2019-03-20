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

public class YandexSpellerTextsTest {

    @Test(groups = "statusCodes")
    public void checkStatusCodeSuccess() {
        RestAssured
                .given(baseRequestConfiguration())
                .get()
                .then().specification(successResponse());
    }

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
