package hw8;

import base.api.YandexSpelleerConstants.*;
import base.api.YandexSpellerApiTexts;
import base.api.beans.YandexSpellerAnswer;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class YandexSpellerTextsTest {

    @Test
    public void checkSpellingSimpleTest() {
        List<YandexSpellerAnswer> answer =
                YandexSpellerApiTexts.getYandexSpellerAnswers(YandexSpellerApiTexts.with().
                         language(Languages.EN)
                        .options(5)
                        .texts(SimpleWord.MINUTE.wrongVer(), SimpleWord.SECOND.wrongVer())
                        .callApi());
        assertThat("Unswers number is not correct.", answer.size(), equalTo(2));
        assertThat("The answer is wrong", answer.get(0).s, hasItem(SimpleWord.MINUTE.corrVer()));
        assertThat("The answer is wrong", answer.get(1).s, hasItem(SimpleWord.SECOND.corrVer()));
    }


}
