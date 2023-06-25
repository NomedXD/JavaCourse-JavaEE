package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.Cart;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class DeleteProductFromCartCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(RequestParamsEnum.SHOPPING_CART.getValue());
        cart.removeProduct(Integer.parseInt(request.getParameter(RequestParamsEnum.PRODUCT_ID.getValue())));
        session.setAttribute(RequestParamsEnum.SHOPPING_CART_PRODUCTS.getValue(), cart);
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
