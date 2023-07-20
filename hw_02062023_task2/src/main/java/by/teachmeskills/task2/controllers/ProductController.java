package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.Cart;
import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ModelAndView getProductPage(@RequestParam(name = "productid") Integer productId) {
        ModelMap model = new ModelMap();
        model.addAttribute(RequestParamsEnum.PRODUCT.getValue(), productService.getProductById(productId));
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), model);
    }

    @GetMapping("/add-product")
    public ModelAndView addProductToCart(@RequestParam(name = "productid") Integer productId,
                                         @SessionAttribute(name = EshopConstants.SHOPPING_CART, required = false) Cart cart) {
        ModelMap model = new ModelMap();
        Product product = productService.getProductById(productId);
        if (cart != null) {
            cart.addProduct(product);
        } else {
            cart = new Cart();
            cart.addProduct(product);
        }
        model.addAttribute(EshopConstants.SHOPPING_CART, cart);
        model.addAttribute(RequestParamsEnum.PRODUCT.getValue(), product);
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), model);
    }
}
