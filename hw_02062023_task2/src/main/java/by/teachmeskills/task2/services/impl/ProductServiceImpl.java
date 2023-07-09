package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.repositories.ProductRepository;
import by.teachmeskills.task2.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.task2.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
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
    public List<Product> getCategoryProducts(int categoryId) {
        return productRepository.getProductsByCategory(categoryId);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductByItsId(id);
    }
}
