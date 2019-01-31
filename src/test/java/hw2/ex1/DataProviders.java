package hw2.ex1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(parallel = true)
    // TODO I suggest use full name of picture
    public Object[][] picTexts() {
        // TODO missing space between []{
        return new Object[][]{
                /* TODO
                    1. String concatenation
                    2. Why you decide use int as parameter for data provider? What is referring for?
                 */
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }
}
