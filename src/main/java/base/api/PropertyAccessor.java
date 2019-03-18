package base.api;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyAccessor {

    public static String getPropertyValue() {
        String url = "";
        InputStream inputStream = null;
        String propFileName = "";
        try {
            try {
                Properties prop = new Properties();
                propFileName = "test.properties";

                inputStream = PropertyAccessor.class.getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
                url = prop.getProperty("url");
            } finally {
                if (inputStream != null) inputStream.close();
            }
        } catch (Exception e) {
            System.out.println("Failed to read file " + propFileName);
            e.printStackTrace();
        }
        return url;
    }
}