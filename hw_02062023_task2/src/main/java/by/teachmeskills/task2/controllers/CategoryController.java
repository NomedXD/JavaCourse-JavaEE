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

@Controller // Пока оставил Controller, пока не предвидится, что будем возвращать json
@RequestMapping("/sneakers-shop")
public class CategoryController {
    private final ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category")
    public ModelAndView getCategoryPage(@RequestParam(name = "categoryid") Integer categoryId) {
        ModelMap model = new ModelMap();
        model.addAttribute(RequestParamsEnum.PRODUCTS.getValue(), productService.getCategoryProducts(categoryId));
        return new ModelAndView(PagesPathEnum.CATEGORY_PAGE.getPath(), model);

        /*
        Есть также новый стиль, когда в метод передается Model model в качестве параметра, потом
        туда добавляются данные, которые хотим отобразить и возвращается лишь страница, например: return
        RequestParamsEnum.PRODUCTS.getValue();, потому что возвращать модель необязательно. Мб потом переписать!
         */
    }
}
