package base.DataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsDataProvider {

    @DataProvider(name = "MetalsAndColorsData")
    public Object[][] getData() throws FileNotFoundException {
        //read the file
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
        //parse the file into JsonObject
        JsonObject fileData = (JsonObject) new JsonParser().parse(reader);
        //create list of JsonElements from the JsonOblect and fill it with json values for each json file data obj - JsonElement
        List<JsonElement> listOfJsons = fileData.keySet().stream().map(fileData::get).collect(Collectors.toList());
        //map the created list of JsonElements on MetalsAndColorsTestData class fields
        List<MetalsAndColorsTestData> listOfTestData = listOfJsons.stream().map(e -> new Gson().fromJson(e, MetalsAndColorsTestData.class)).collect(Collectors.toList());
        //fill in the dataProvider Object[][] with the testdata (1 stands for MetalsAndColorsTestData obj)
        Object[][] finalData = new Object[listOfTestData.size()][1];
        int index = 0;
        for (Object[] each : finalData) {
            each[0] = listOfTestData.get(index++);
        }
        return finalData;
    }
}
