package by.teachmeskills.task2.repositories.impl;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.repositories.ConnectionPool;
import by.teachmeskills.task2.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM products WHERE categoryid = ?";
    private static final String GET_PRODUCT_BY_ITS_ID = "SELECT * FROM products WHERE id = ?";

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
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

    @Override
    public Product getProductByItsId(int id) {
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
}
