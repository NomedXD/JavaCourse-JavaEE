package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.Category;

public interface CategoryService extends BaseService<Category>{
    Category getCategoryByName(String name);
}
