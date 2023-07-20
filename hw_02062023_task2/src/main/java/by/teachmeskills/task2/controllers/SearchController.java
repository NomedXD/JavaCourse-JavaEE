package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.Product;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sneakers-shop")
public class SearchController {
    private final ProductService productService;

    @Autowired
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ModelAndView getSearchPage() {
        ModelMap model = new ModelMap();
        model.addAttribute(RequestParamsEnum.PRODUCTS.getValue(), productService.read());
        return new ModelAndView(PagesPathEnum.SEARCH_PAGE.getPath(), model);
    }

    @PostMapping("/search")
    public ModelAndView submitSearch(@RequestParam(name = "searchField") String searchString) {
        ModelMap model = new ModelMap();
        List<Product> productList = productService.getSearchedProducts(searchString);
        model.addAttribute(RequestParamsEnum.PRODUCTS.getValue(), productList);
        return new ModelAndView(PagesPathEnum.SEARCH_PAGE.getPath(), model);
    }
}
