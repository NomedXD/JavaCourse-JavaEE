package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.Product;

import java.util.List;

public interface ProductService extends BaseService<Product>{
    List<Product> getProductsByCategoryService(int categoryId);
    Product getProductByItsIdService(int id);
}
