package by.teachmeskills.task2.repositories;

import by.teachmeskills.task2.domain.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getProductsByCategory(int categoryId);
    Product getProductByItsId(int id);
}
