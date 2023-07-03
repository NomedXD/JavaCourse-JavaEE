package by.teachmeskills.task2.repositories.impl;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.repositories.ConnectionPool;
import by.teachmeskills.task2.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static final String GET_USER_QUERY = "SELECT * FROM users WHERE mail = ? AND password = ?";
    private static final String REGISTER_USER = "INSERT INTO users(mail, password, name, surname, date," +
            " balance) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_DATA = "UPDATE users SET mobile = ?, street = ?, accommodation_number = ?, flat_number = ? WHERE id = ?";
    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(User entity) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER_DATA);
            preparedStatement.setString(1, entity.getMobile());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getAccommodationNumber());
            preparedStatement.setString(4, entity.getFlatNumber());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
            entity = getUser(entity.getMail(), entity.getPassword());
            return entity;
        } catch (SQLException e) {
            logger.warn("SQLException while saving user. Most likely request is wrong");
            return entity;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getUser(String mail, String password) {
        User user = null;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("mail"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("surname"), resultSet.getDate("date"),
                        resultSet.getFloat("balance"), resultSet.getString("mobile"),
                        resultSet.getString("street"), resultSet.getString("accommodation_number"),
                        resultSet.getString("flat_number"));
            }
            return user;
        } catch (SQLException e) {
            logger.warn("SQLException while getting user. Most likely request is wrong");
            return null;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public User saveUser(String email, String name, String surname, String password, String date, float balance) {
        User user;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.setDate(5, java.sql.Date.valueOf(date));
            preparedStatement.setFloat(6, balance);
            preparedStatement.execute();
            user = getUser(email, password);
            return user;
        } catch (SQLException e) {
            logger.warn("SQLException while saving user. Most likely request is wrong");
            return null;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}
