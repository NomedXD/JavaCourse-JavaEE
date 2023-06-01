package by.teachmeskills.task1.task1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CRUDUtils {
    private static final String GET_USER_QUERY = "SELECT * FROM 02062023_task1";

    public static List<String> getInfo(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_USER_QUERY);
            resultSet.next();
            List<String> result = new ArrayList<>();
            Collections.addAll(result, resultSet.getString("info1"), resultSet.getString("imgpath"), resultSet.getString("maininfo"));
            return result;
        } catch (SQLException e) {
            return null;
        }
    }
}
