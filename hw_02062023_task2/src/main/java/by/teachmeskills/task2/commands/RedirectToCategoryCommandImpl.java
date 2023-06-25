package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToCategoryCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestParamsEnum.PRODUCTS.getValue(), CRUDUtils.getProductsByCategory(Integer.parseInt(request.getParameter(RequestParamsEnum.CATEGORYID.getValue()))));
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
