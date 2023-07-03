package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.repositories.ProductRepository;
import by.teachmeskills.task2.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.task2.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public Product createService(Product entity) {
        return null;
    }

    @Override
    public List<Product> readService() {
        return null;
    }

    @Override
    public Product updateService(Product entity) {
        return null;
    }

    @Override
    public void deleteService(int id) {

    }

    @Override
    public List<Product> getProductsByCategoryService(int categoryId) {
        return productRepository.getProductsByCategory(categoryId);
    }

    @Override
    public Product getProductByItsIdService(int id) {
        return productRepository.getProductByItsId(id);
    }
}
