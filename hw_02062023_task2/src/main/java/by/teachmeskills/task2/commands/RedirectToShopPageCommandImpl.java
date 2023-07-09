package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.CategoryService;
import by.teachmeskills.task2.services.impl.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToShopPageCommandImpl implements BaseCommand {
    private static final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.read());
        return PagesPathEnum.SHOP_PAGE.getPath();
    }
}

