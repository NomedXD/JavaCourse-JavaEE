package by.teachmeskills.task2.repositories.impl;

import by.teachmeskills.task2.domain.Category;
import by.teachmeskills.task2.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final static Logger logger = LoggerFactory.getLogger(CategoryRepositoryImpl.class);
    private static final String GET_All_CATEGORIES = "SELECT * FROM categories";
    @Override
    public Category create(Category entity) {
        return null;
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
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
