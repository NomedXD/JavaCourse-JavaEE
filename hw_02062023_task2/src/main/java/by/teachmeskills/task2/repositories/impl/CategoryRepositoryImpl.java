package by.teachmeskills.task2.repositories.impl;

import by.teachmeskills.task2.domain.Category;
import by.teachmeskills.task2.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final static Logger logger = LoggerFactory.getLogger(CategoryRepositoryImpl.class);
    private static final String CREATE_CATEGORY = "INSERT INTO categories(name, imagepath, sometext) VALUES (?, ?, ?)";
    private static final String GET_All_CATEGORIES = "SELECT * FROM categories";
    private static final String UPDATE_CATEGORY_DATA = "UPDATE categories SET name = ?, imagepath = ?, sometext = ? WHERE id = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";
    private static final String GET_CATEGORY_BY_ITS_NAME = "SELECT * FROM categories WHERE name = ?";

    @Override
    public Category create(Category entity) {
        Category category = new Category();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CATEGORY);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getImagepath());
            preparedStatement.setString(3, entity.getSometext());
            preparedStatement.execute();
            category = getCategoryByName(entity.getName());
            return category;
        } catch (SQLException e) {
            logger.warn("SQLException while creating category. Most likely request is wrong");
            return category;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public List<Category> read() {
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

    @Override
    public Category update(Category entity) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_DATA);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getImagepath());
            preparedStatement.setString(3, entity.getSometext());
            preparedStatement.setInt(4, entity.getId());
            preparedStatement.executeUpdate();
            entity = getCategoryByName(entity.getName());
            return entity;
        } catch (SQLException e) {
            logger.warn("SQLException while updating category. Most likely request is wrong");
            return entity;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("SQLException while deleting category. Most likely request is wrong");
        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = new Category();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ITS_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("imagepath"), resultSet.getString("sometext"));
            }
            return category;
        } catch (SQLException e) {
            logger.warn("SQLException while getting category by it's id. Most likely request is wrong");
            return category;
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}
