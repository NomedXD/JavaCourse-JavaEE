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
        return productRepository.create(entity);
    }

    @Override
    public List<Product> read() {
        return productRepository.read();
    }

    @Override
    public Product update(Product entity) {
        return productRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getCategoryProducts(int categoryId) {
        return productRepository.getCategoryProducts(categoryId);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }
}
