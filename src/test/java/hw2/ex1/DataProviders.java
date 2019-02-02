package hw2.ex1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(parallel = true)
    public Object[][] benefitIconsText() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
}
