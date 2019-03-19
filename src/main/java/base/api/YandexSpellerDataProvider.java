package base.api;

import org.testng.annotations.DataProvider;
import base.api.YandexSpellerConstants.Languages;

public class YandexSpellerDataProvider {

    @DataProvider(name = "yandexSpellerData")
    public Object[][] getData() {
        return new Object[][]{
                {new Languages[]{Languages.EN},
                        new String[]{"minuute", "houur"},
                        new String[]{"minute", "hour"}},
                {new Languages[]{Languages.RU},
                        new String[]{"минутта", "ччас"},
                        new String[]{"минута", "час"}},
                {new Languages[]{Languages.UK},
                        new String[]{"хвиллина", "годиина"},
                        new String[]{"хвилина", "година"}},
                {new Languages[]{Languages.UK, Languages.EN, Languages.RU},
                        new String[]{"хвиллина", "minuute", "минутта"},
                        new String[]{"хвилина", "minute", "минута"}}
        };
    }
}