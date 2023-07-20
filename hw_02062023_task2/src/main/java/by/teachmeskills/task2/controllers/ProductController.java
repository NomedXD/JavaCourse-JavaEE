package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getProductPage(@RequestParam(name = "productid") Integer productId) {
        ModelMap model = new ModelMap();
        model.addAttribute(RequestParamsEnum.PRODUCT.getValue(), productService.getProductById(productId));
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), model);
    }
}
