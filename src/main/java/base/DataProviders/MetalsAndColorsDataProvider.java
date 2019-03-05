package base.DataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class MetalsAndColorsDataProvider {

    @DataProvider(name = "MetalsAndColorsData")
    public Object[][] getData() throws FileNotFoundException {
        //read the file
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
        //parse the file into JsonObject
        JsonObject fileData = (JsonObject) new JsonParser().parse(reader);
        //map the created Json on MetalsAndColorsTestData class fields using Map<String, MetalsAndColorsTestData>
        Map<String, MetalsAndColorsTestData> listOfTestData = new Gson().fromJson(fileData, new TypeToken<Map<String, MetalsAndColorsTestData>>() {
        }.getType());
        //fill in the dataProvider Object[][] with the testdata (1 stands for MetalsAndColorsTestData obj)
        Object[][] finalData = new Object[listOfTestData.size()][1];
        for (int index = 0; index < finalData.length; index++) {
            //fill the finalData[][] with the values from map listOfTestData
            finalData[index][0] = listOfTestData.get(listOfTestData.keySet().toArray()[index]);
        }
        return finalData;
    }
}