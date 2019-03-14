package hw8;

import base.api.YandexSpelleerConstants.*;
import base.api.YandexSpellerApiTexts;
import base.api.beans.YandexSpellerAnswer;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class YandexSpellerTextsTest {

    @Test
    public void checkSpellingEnglishWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                         language(Languages.EN)
                        .texts(SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.HOUR_EN.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_EN.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_EN.corrVer()));
    }

    @Test
    public void checkSpellingRussianWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                        language(Languages.RU)
                        .texts(SimpleWord.MINUTE_RU.wrongVer(), SimpleWord.HOUR_RU.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_RU.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_RU.corrVer()));
    }

    @Test
    public void checkSpellingUkranianWords() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                        language(Languages.UK)
                        .texts(SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.HOUR_UK.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_UK.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.HOUR_UK.corrVer()));
    }

    @Test
    public void checkSpellingAllLanguages() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                        language(Languages.UK, Languages.EN, Languages.RU)
                        .texts(SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.MINUTE_RU.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(3));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE_UK.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.MINUTE_EN.corrVer()));
        assertThat("The answer is wrong", answer.get(2).s, hasItem(SimpleWord.MINUTE_RU.corrVer()));
    }

    @Test
    public void checkIgnoreDigitsOption() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                        language(Languages.EN)
                        .options(2)
                        .texts(SimpleWord.MINUTE_EN.wrongVer()+"123")
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }

    @Test
    public void checkIgnoreUrlsOption() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                        language(Languages.EN)
                        .options(4)
                        .texts("http://ya.ru")
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(0));
    }

}
