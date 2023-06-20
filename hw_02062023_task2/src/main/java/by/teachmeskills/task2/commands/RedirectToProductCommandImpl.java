package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToProductCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestParamsEnum.PRODUCT.getValue(), CRUDUtils.getProductByItsId(Integer.parseInt(request.getParameter(RequestParamsEnum.PRODUCT_ID.getValue()))));
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
