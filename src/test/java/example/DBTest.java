package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class DBTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test(dataProvider = "first_query", dataProviderClass = DataProviders.class)
    void test1(String query) {
        logger.info(DBUtils.performQuery(query));
    }

    @Test(dataProvider = "second_query", dataProviderClass = DataProviders.class)
    void test2(String query) {
        logger.info(DBUtils.performQuery(query));
    }

    @Test(dataProvider = "third_query", dataProviderClass = DataProviders.class)
    void test3(String query, String date) {
        logger.info(DBAppRequests.dateQuery(query, date));
    }

    @Test(dataProvider = "fourth_query", dataProviderClass = DataProviders.class)
    void test4(String query, String[] browsers) {
        logger.info(DBAppRequests.browserQuery(query, browsers));
    }
}
