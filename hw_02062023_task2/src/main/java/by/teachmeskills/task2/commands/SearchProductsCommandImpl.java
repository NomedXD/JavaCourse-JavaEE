package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class SearchProductsCommandImpl implements BaseCommand {
    private static final ProductService productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String searchString = request.getParameter(RequestParamsEnum.SEARCH_FIELD.getValue());
        List<Product> productList = productService.getSearchedProducts(searchString);
        request.setAttribute(RequestParamsEnum.PRODUCTS.getValue(), productList);
        return PagesPathEnum.SEARCH_PAGE.getPath();
    }
}
