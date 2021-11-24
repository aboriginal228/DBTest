package example;

public class DBAppRequests {

    public static String dateQuery(String query, String date) {
        String result = query.replace("DATE", date);
        return DBUtils.performQuery(result);
    }

    public static String browserQuery(String query, String[] browsers) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < browsers.length; i++) {
            if (i != 0) {
                result.append(" union ");
            }
            result.append(query.replace("BROWSER", browsers[i]));
        }

        return result.toString();
    }
}
