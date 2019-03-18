package base.api;

import org.testng.annotations.DataProvider;
import base.api.YandexSpellerConstants.Languages;
import base.api.YandexSpellerConstants.SimpleWord;

public class YandexSpellerDataProvider {

    @DataProvider(name = "yandexSpellerData")
    public Object[][] getData() {
        return new Object[][]{
                {Languages.EN,
                        new String[]{SimpleWord.MINUTE_EN.wrongVer(), SimpleWord.HOUR_EN.wrongVer()},
                        new String[]{SimpleWord.MINUTE_EN.corrVer(), SimpleWord.HOUR_EN.corrVer()}},
                {Languages.RU,
                        new String[]{SimpleWord.MINUTE_RU.wrongVer(), SimpleWord.HOUR_RU.wrongVer()},
                        new String[]{SimpleWord.MINUTE_RU.corrVer(), SimpleWord.HOUR_RU.corrVer()}},
                {Languages.UK,
                        new String[]{SimpleWord.MINUTE_UK.wrongVer(), SimpleWord.HOUR_UK.wrongVer()},
                        new String[]{SimpleWord.MINUTE_UK.corrVer(), SimpleWord.HOUR_UK.corrVer()}}
        };
    }
}