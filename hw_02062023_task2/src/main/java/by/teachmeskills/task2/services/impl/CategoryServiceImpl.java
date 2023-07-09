package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.Category;
import by.teachmeskills.task2.repositories.CategoryRepository;
import by.teachmeskills.task2.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.task2.services.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public Category create(Category entity) {
        return categoryRepository.create(entity);
    }

    @Override
    public List<Category> read() {
        return categoryRepository.read();
    }

    @Override
    public Category update(Category entity) {
        return categoryRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }
}
