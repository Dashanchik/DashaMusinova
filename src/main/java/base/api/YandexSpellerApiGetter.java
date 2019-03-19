package base.api;

import base.api.beans.YandexSpellerAnswer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class YandexSpellerApiGetter {

    public static List<YandexSpellerAnswer> getYandexSpellerAnswers(Response response) {
        List<List<YandexSpellerAnswer>> answersList = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<List<YandexSpellerAnswer>>>() {
                }.getType());
        List<YandexSpellerAnswer> finalAnswerList = new ArrayList<>();
        for (List<YandexSpellerAnswer> answer : answersList) {
            if (answer.size() < 1) {
                return finalAnswerList;
            }
            finalAnswerList.add(answer.get(0));
        }
        return finalAnswerList;
    }
}
