package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToSearchCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ProductService productService = new ProductServiceImpl();
        request.setAttribute(RequestParamsEnum.PRODUCTS.getValue(), productService.read());
        return PagesPathEnum.SEARCH_PAGE.getPath();
    }
}
