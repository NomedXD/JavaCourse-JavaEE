package by.teachmeskills.task2.db;

import by.teachmeskills.task2.domain.Category;
import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private final static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static final ConnectionPool connectionPool;
    private static final String GET_USER_QUERY = "SELECT * FROM users WHERE mail = ? AND password = ?";
    private static final String GET_All_CATEGORIES = "SELECT * FROM categories";
    private static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM products WHERE categoryid = ?";
    private static final String GET_PRODUCT_BY_ITS_ID = "SELECT * FROM products WHERE id = ?";
    private static final String REGISTER_USER = "INSERT INTO users(mail, password, name, surname, date," +
            " balance) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_DATA = "UPDATE users SET mobile = ?, street = ?, accommodation_number = ?, flat_number = ? WHERE id = ?";

    static {
        connectionPool = ConnectionPool.getInstance();
    }

    public static User getUser(String mail, String password) {
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

    public static List<Category> getAllCategories() {
        List<Category> categoryArrayList = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_All_CATEGORIES);
            while (resultSet.next()) {
                categoryArrayList.add(new Category(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("sometext")));
            }
            return categoryArrayList;
        } catch (SQLException e) {
            logger.warn("SQLException while getting categories. Most likely request is wrong");
            return categoryArrayList;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    public static List<Product> getProductsByCategory(int categoryId) {
        List<Product> productList = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("description"),
                        resultSet.getInt("categoryid"), resultSet.getFloat("price")));
            }
            return productList;
        } catch (SQLException e) {
            logger.warn("SQLException while getting products by category. Most likely request is wrong");
            return productList;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    public static Product getProductByItsId(int id) {
        Product product = null;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ITS_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("description"),
                        resultSet.getInt("categoryid"), resultSet.getFloat("price"));
            }
            return product;
        } catch (SQLException e) {
            logger.warn("SQLException while getting product by it's id. Most likely request is wrong");
            return null;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    public static User saveUser(String email, String name, String surname, String password, String date, float balance) {
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

    public static User updateUserData(User user) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER_DATA);
            preparedStatement.setString(1, user.getMobile());
            preparedStatement.setString(2, user.getStreet());
            preparedStatement.setString(3, user.getAccommodationNumber());
            preparedStatement.setString(4, user.getFlatNumber());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
            user = getUser(user.getMail(), user.getPassword());
            return user;
        } catch (SQLException e) {
            logger.warn("SQLException while saving user. Most likely request is wrong");
            return user;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}
