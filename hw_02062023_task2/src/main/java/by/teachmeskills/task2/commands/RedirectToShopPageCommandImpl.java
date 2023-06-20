package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToShopPageCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), CRUDUtils.getAllCategories());
        return PagesPathEnum.SHOP_PAGE.getPath();
    }
}

