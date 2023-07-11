package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SearchProductsCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String searchString = request.getParameter(RequestParamsEnum.SEARCH_FIELD.getValue());
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.read();
        Predicate<Product> productPredicate1 = pr1 -> pr1.getName().contains(searchString);
        Predicate<Product> productPredicate2 = pr2 -> pr2.getDescription().contains(searchString);
        List<Product> productList = Stream.concat(products.stream().filter(productPredicate1), products.stream().filter(productPredicate2)).distinct().toList();
        request.setAttribute(RequestParamsEnum.PRODUCTS.getValue(), productList);
        return PagesPathEnum.SEARCH_PAGE.getPath();
    }
}
