package by.teachmeskills.task2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private final Map<Integer, Product> products;
    private String totalPrice;

    public Cart() {
        this.products = new HashMap<>();
        this.totalPrice = "0$";
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        totalPrice = Float.parseFloat(totalPrice.replaceAll("\\$", "")) +
                Float.parseFloat(product.getPrice().replaceAll("\\$", "")) + "$";
    }

    public void removeProduct(int productId) {
        Product product = products.get(productId);
        products.remove(productId);
        totalPrice = Float.parseFloat(totalPrice.replaceAll("\\$", "")) -
                Float.parseFloat(product.getPrice().replaceAll("\\$", "")) + "$";
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public int getTotalSize() {
        return products.size();
    }

    public void clear() {
        products.clear();
    }

}
