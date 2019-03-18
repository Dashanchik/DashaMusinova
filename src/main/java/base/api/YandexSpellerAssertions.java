package base.api;

import base.api.beans.YandexSpellerAnswer;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class YandexSpellerAssertions {

    public static void assertAnswerSize(List<YandexSpellerAnswer> answer, int size) {
        assertThat("Unswers number is not correct.", answer.size(), equalTo(size));
    }

    public static void assertAnswerIsCorrect(List<YandexSpellerAnswer> answer, int answerNumber, String corrVer) {
        assertThat("The answer is wrong", answer.get(answerNumber).s, hasItem(corrVer));
    }

    public static void assertAnswersIsCorrect(List<YandexSpellerAnswer> answers, String[] correctAnswers) {
        for (int i = 0; i < correctAnswers.length; i++){
            assertThat("The answer is wrong", answers.get(i).s, hasItem(correctAnswers[i]));
        }
    }

    public static void assertErrorCodeIsCorrect(List<YandexSpellerAnswer> answer, int answerNumber, int errCode) {
        assertThat("Errorcode is not correct.", answer.get(answerNumber).code, equalTo(errCode));
    }
}
