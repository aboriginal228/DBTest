package example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.*;

public class DBUtils {

    public static String performQuery(String query) {

        try (Connection con = DriverManager
                .getConnection(ConfigUtil.getBaseUrl(), ConfigUtil.getLogin(), ConfigUtil.getPass())) {
            try (Statement stmt = con.createStatement()) {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream old = System.out;
                System.setOut(ps);

                ResultSet rs = stmt.executeQuery(query);
                DBTablePrinter.printResultSet(rs);

                System.out.flush();
                System.setOut(old);

                rs.close();

                return baos.toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}
