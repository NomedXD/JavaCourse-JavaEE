package by.teachmeskills.task2.db;

import by.teachmeskills.task2.Category;
import by.teachmeskills.task2.Product;
import by.teachmeskills.task2.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String GET_USER_QUERY = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String GET_All_CATEGORIES = "SELECT * FROM categories";
    private static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM products WHERE categoryid = ?";

    public static User getUser(String login, String password, Connection connection) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("balance"));
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<Category> getAllCategories(Connection connection){
        List<Category> categoryArrayList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_All_CATEGORIES);
            while (resultSet.next()){
                categoryArrayList.add(new Category(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("sometext")));
            }
            return categoryArrayList;
        } catch (SQLException e) {
            return categoryArrayList;
        }
    }

    public static List<Product> getProductsByCategory(int categoryId, Connection connection){
        List<Product> productList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("description"),
                        resultSet.getInt("categoryid")));
            }
            return productList;
        } catch (SQLException e) {
            return productList;
        }
    }
}
