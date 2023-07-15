package by.teachmeskills.task2.repositories;

import by.teachmeskills.task2.domain.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getCategoryProducts(int categoryId);

    Product getProductById(int id);

    Product getProductByName(String name);

    List<Product> getSearchedProducts(String searchString);
}
