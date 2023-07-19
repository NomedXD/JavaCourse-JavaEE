package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sneakers-shop")
public class CategoryController {
    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/category")
    public ModelAndView getCategoryPage(@RequestParam(name = "categoryid") String categoryId){
        ModelMap model = new ModelMap();
        model.addAttribute(RequestParamsEnum.PRODUCTS.getValue(), productService.getCategoryProducts(Integer.parseInt(categoryId)));
        return new ModelAndView(PagesPathEnum.CATEGORY_PAGE.getPath(), model);
    }
}
