package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.Category;
import by.teachmeskills.task2.repositories.CategoryRepository;
import by.teachmeskills.task2.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.task2.services.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public Category createService(Category entity) {
        return null;
    }

    @Override
    public List<Category> readService() {
       return categoryRepository.read();
    }

    @Override
    public Category updateService(Category entity) {
        return null;
    }

    @Override
    public void deleteService(int id) {

    }
}
