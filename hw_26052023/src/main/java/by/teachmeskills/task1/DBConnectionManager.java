package by.teachmeskills.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionManager {
    private String url;
    private String login;
    private String password;
    private Connection connection;
    public static String GET_USER_QUERY = "SELECT * FROM users WHERE login = ? AND password = ?";

    public DBConnectionManager(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUserDB(String login, String password){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(resultSet.getString("login"), resultSet.getString("password"));
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось закрыть подключение из-за ошибки");
        }
    }
}
