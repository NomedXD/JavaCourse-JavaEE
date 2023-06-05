package by.teachmeskills.task1.task1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CRUDUtils {
    private static final String GET_USER_QUERY = "SELECT * FROM 02062023_task1";

    public static Map<String, String> getInfo(Connection connection) {
        Map<String, String> userData = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_USER_QUERY);
            while (resultSet.next()) {
                userData.put("info1", resultSet.getString("info1"));
                userData.put("imgpath", resultSet.getString("imgpath"));
                userData.put("maininfo", resultSet.getString("maininfo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return userData;
    }
}
