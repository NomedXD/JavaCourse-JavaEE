package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToCartCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
