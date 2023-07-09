package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToProductCommandImpl implements BaseCommand {
    private static final ProductService productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestParamsEnum.PRODUCT.getValue(), productService.getProductById(Integer.parseInt(request.getParameter(RequestParamsEnum.PRODUCT_ID.getValue()))));
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
