package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<Product> getCategoryProducts(int categoryId);

    Product getProductById(int id);

    Product getProductByName(String name);

    List<Product> getSearchedProducts(String searchString);
}
