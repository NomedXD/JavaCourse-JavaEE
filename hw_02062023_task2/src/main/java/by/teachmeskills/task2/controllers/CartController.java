package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.Cart;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({EshopConstants.SHOPPING_CART})
@RequestMapping("/sneakers-shop")
public class CartController {
    @GetMapping("/cart")
    public ModelAndView getShoppingCart() {
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath());
    }

    @GetMapping("/remove-product")
    public ModelAndView deleteProductFromCart(@RequestParam(name = "productid") Integer productId,
                                              @SessionAttribute(EshopConstants.SHOPPING_CART) Cart cart) {
        ModelMap model = new ModelMap();
        cart.removeProduct(productId);
        model.addAttribute(RequestParamsEnum.SHOPPING_CART_PRODUCTS.getValue(), cart);
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath(), model);
    }
}
