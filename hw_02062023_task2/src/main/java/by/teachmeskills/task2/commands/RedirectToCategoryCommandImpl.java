package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToCategoryCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ProductService productService = new ProductServiceImpl();
        request.setAttribute(RequestParamsEnum.PRODUCTS.getValue(), productService.getProductsByCategoryService(Integer.parseInt(request.getParameter(RequestParamsEnum.CATEGORYID.getValue()))));
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
