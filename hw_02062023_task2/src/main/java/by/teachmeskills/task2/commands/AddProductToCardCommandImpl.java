package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.domain.Cart;
import by.teachmeskills.task2.domain.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import static by.teachmeskills.task2.enums.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.task2.enums.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.task2.enums.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.task2.enums.RequestParamsEnum.SHOPPING_CART;

public class AddProductToCardCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = CRUDUtils.getProductByItsId(productId);
        Cart cart = (Cart) session.getAttribute("cart");
        if (Optional.ofNullable(cart).isPresent()) {
            cart.addProduct(product);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
        } else {
            cart = new Cart();
            cart.addProduct(product);
            session.setAttribute(SHOPPING_CART.getValue(), cart);
        }
        request.setAttribute(PRODUCT.getValue(), product);
        return PRODUCT_PAGE.getPath();
    }
}
