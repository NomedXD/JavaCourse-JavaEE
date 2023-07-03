package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.CategoryService;
import by.teachmeskills.task2.services.impl.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToShopPageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        CategoryService categoryService = new CategoryServiceImpl();
        request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.readService());
        return PagesPathEnum.SHOP_PAGE.getPath();
    }
}

