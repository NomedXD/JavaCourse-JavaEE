package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.Cart;
import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.services.ProductService;
import by.teachmeskills.task2.services.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import static by.teachmeskills.task2.enums.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.task2.enums.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.task2.enums.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.task2.enums.RequestParamsEnum.SHOPPING_CART;

public class AddProductToCardCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(productId);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
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
