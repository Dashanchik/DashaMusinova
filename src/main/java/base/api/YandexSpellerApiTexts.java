package base.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static base.api.PropertyAccessor.getPropertyValue;
import static base.api.YandexSpellerConstants.*;
import static org.hamcrest.Matchers.lessThan;

public class YandexSpellerApiTexts {

    private YandexSpellerApiTexts() {
    }//todo зачем дефолтный конструктор? ***з*** - чтобы нельзя было создать объект класса

    private HashMap<String, Object> params = new HashMap<>();

    public static class ApiBuilder {//todo отправь либо вниз класса, а лучше в отдельный файл - done, он внизу класса. не вижу смысла в отдельный класс его выносить - тут не очень много логики и она вся про создание апи запроса
        YandexSpellerApiTexts spellerApi;

        private ApiBuilder(YandexSpellerApiTexts gcApi) {
            spellerApi = gcApi;
        }

        public ApiBuilder texts(String... texts) {
            List<String> textsList = Arrays.asList(texts);
            spellerApi.params.put(PARAM_TEXTS, textsList);
            return this;
        }

        public ApiBuilder options(int... options) {
            spellerApi.params.put(PARAM_OPTIONS, Integer.toString(IntStream.of(options).sum()));
            return this;
        }

        public ApiBuilder languages(YandexSpellerConstants.Languages... languages) {
            List<String> languagesList = new ArrayList<>();
            for (YandexSpellerConstants.Languages language : languages) {
                languagesList.add(language.getLang());
            }
            String newLanguageList = String.join(", ", languagesList);
            spellerApi.params.put(PARAM_LANGUAGES, newLanguageList);
            return this;
        }

        public Response getYandexSpellerApi() { // todo вообще не очень говорящее название метода. если метод делает get, то  и назввай его getSomething()... - done
            return RestAssured.with()
                    .queryParams(spellerApi.params)
                    .log().all()
                    .get(getPropertyValue()+YANDEX_SPELLER_API_URI).prettyPeek();
        }

        public static ApiBuilder with() {
            YandexSpellerApiTexts api = new YandexSpellerApiTexts();
            return new ApiBuilder(api);
        }

        public static ResponseSpecification successResponse() {
            return new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .expectHeader("Connection", "keep-alive")
                    .expectResponseTime(lessThan(20000L))
                    .expectStatusCode(HttpStatus.SC_OK)
                    .build();
        }

        public static RequestSpecification baseRequestConfiguration() {
            return new RequestSpecBuilder()
                    .setAccept(ContentType.XML)
                    //todo зачем это? - deleted
                    //todo зачем это? - deleted
                    //todo зачем это? - deleted
                    .setBaseUri(getPropertyValue()+YANDEX_SPELLER_API_URI)
                    .build();
        }
    }
}

