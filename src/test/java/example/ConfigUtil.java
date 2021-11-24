package example;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static Properties property;

    static {
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties")){
            property = new Properties();
            property.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Config is not loaded");
        }
    }

    public static String getBaseUrl() {
        return property.getProperty("base-url");
    }

    public static String getLogin() {
        return property.getProperty("base-login");
    }

    public static String getPass() {
        return property.getProperty("base-pass");
    }
}
