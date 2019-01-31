package hw2.ex1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(parallel = true)
    // TODO I suggest use full name of picture - fixed
    public Object[][] benefitIconsText() {
        // TODO missing space between []{ - fixed
        return new Object[][]{
                /* TODO - fixed

                    1. String concatenation - fixed
                    2. Why you decide use int as parameter for data provider? What is referring for? - used to define it's place in the parent webelement - to have the possibility to iterate through this array and the child elements in the same order in the IndexPicTest test
                 */
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
}
