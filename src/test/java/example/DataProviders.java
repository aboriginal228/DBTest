package example;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataProviders {

    @DataProvider(name = "first_query")
    public static Object[][] first() {
        try {
            String query = new String(Files.readAllBytes(Paths.get("src/test/resources/first.sql")));
            return new Object[][] {{query}};
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @DataProvider(name = "second_query")
    public static Object[][] second() {
        try {
            String query = new String(Files.readAllBytes(Paths.get("src/test/resources/second.sql")));
            return new Object[][] {{query}};
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @DataProvider(name = "third_query")
    public static Object[][] third() {
        try {
            String query = new String(Files.readAllBytes(Paths.get("src/test/resources/third.sql")));
            String date = TestDataUtil.getDate();
            return new Object[][] {{query, date}};
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @DataProvider(name = "fourth_query")
    public static Object[][] fourth() {
        try {
            String[] browsers = TestDataUtil.getBrowsers();
            String query = new String(Files.readAllBytes(Paths.get("src/test/resources/fourth.sql")));
            return new Object[][] {{query, browsers}};
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
