package example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataUtil {

    private static Properties property;

    static {
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/testData.properties")){
            property = new Properties();
            property.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Config is not loaded");
        }
    }

    public static String getDate() {
        return property.getProperty("date");
    }

    public static String[] getBrowsers() {
        return property.getProperty("browsers").split(",");
    }

    public static String getPass() {
        return property.getProperty("base-pass");
    }
}
