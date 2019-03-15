package api.hw8;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import base.api.YandexSpelleerConstants.Languages;
import base.api.YandexSpelleerConstants.SimpleWord;
import base.api.YandexSpellerApiTexts;
import base.api.beans.YandexSpellerAnswer;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

//todo постарайся разгруппировать по сьюттам, тестов не очень много, но все-таки так будет наглянее
public class YandexSpellerTextsTest {

    @Test
    public void checkStatusCodeSuccess() {
        RestAssured
                .given(YandexSpellerApiTexts.baseRequestConfiguration())//todo не стесняйся использовать статический импорт - так читабельнее
                .get().prettyPeek()//todo .prettyPeek() в этом нет необходимости
                .then().specification(YandexSpellerApiTexts.successResponse());
    }

    //todo checkSpellingEnglishWords, checkSpellingRussianWords, checkSpellingUkranianWords
    //todo тут один сценарий и незачем его кописровать - просто используй DataProvider
    @Test
    public void checkSpellingEnglishWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .texts(SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.HOUR_EN.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_EN.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_EN.corrVer()));
    }

    @Test
    public void checkSpellingRussianWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.RU)
                        .texts(SimpleWord.MINUTE_RU.wrongVer(), SimpleWord.HOUR_RU.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_RU.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_RU.corrVer()));
    }

    @Test
    public void checkSpellingUkranianWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.UK)
                        .texts(SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.HOUR_UK.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));//todo "Unswers number is not correct."
        //todo сильно много, где встречается. лучше спрятать это в отдельный класс с асертами и назвать метод, например, assertAnswerSize(answer, 2);
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_UK.corrVer()));//todo комментарий аналогичный
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_UK.corrVer()));
    }

    @Test
    public void checkSpellingAllLanguages() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.UK, Languages.EN, Languages.RU)
                        .texts(SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.MINUTE_RU.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(3));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_UK.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.MINUTE_EN.corrVer()));
        assertThat("The answer is wrong", answer.get(2).s, hasItem(SimpleWord.MINUTE_RU.corrVer()));
    }

    //Test fails
    @Test
    public void checkUnknownWordError() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.UNKNOWN_WORD.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(1));
        assertThat("Errorcode is not correct", answer.get(0).code, equalTo(1));
    }

    @Test
    public void checkIgnoreDigitsOption() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(2)
                        .texts(SimpleWord.MINUTE_EN.corrVer() + "123")
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }

    @Test
    public void checkDigitsError() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.MINUTE_EN.corrVer() + "123")
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(1));
        assertThat("Unswer is not correct.", answer.get(0).s, hasItem(SimpleWord.MINUTE_EN.corrVer() + " " + "123"));
        assertThat("Errorcode is not correct", answer.get(0).code, equalTo(1));
    }

    @Test
    public void checkIgnoreUrlsAndDigitsOption() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(2, 4)
                        .texts(SimpleWord.URL.wrongVer() + "555")
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }

    //Test fails
    @Test
    public void checkCapitalLettersError() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(0)
                        .texts(SimpleWord.WORD_WITH_CAPITALS.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(1));
        assertThat("Errorcode is not correct.", answer.get(0), equalTo(3));
    }

    @Test
    public void checkIgnoreCapitalLettersAndDigitsOption() {
        List<YandexSpellerAnswer> answer =
                //todo разнеси по разным класса формаорование запроса и его исполнение
                //todo getYandexSpellerAnswers & with должны быть в разных классах
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.EN)
                        .options(2, 4, 512)
                        .texts(SimpleWord.WORD_WITH_CAPITALS.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }

    @Test
    public void checkFindRepeatWordsOption() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with()
                        .language(Languages.RU)
                        .options(512)
                        .texts(SimpleWord.REPEAT_WORD.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }
}
