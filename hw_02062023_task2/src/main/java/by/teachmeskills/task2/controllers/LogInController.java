package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.CategoryService;
import by.teachmeskills.task2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({EshopConstants.USER})
@RequestMapping("/sneakers-shop")
public class LogInController {
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public LogInController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView(PagesPathEnum.LOG_IN_PAGE.getPath());
    }

    @PostMapping("/login")
    public ModelAndView logIn(@ModelAttribute(EshopConstants.USER) User user) {
        ModelMap model = new ModelMap();
        User loggedUser = userService.getUserByCredentials(user.getMail(), user.getPassword());
        if (loggedUser != null) {
            model.addAttribute(EshopConstants.USER, loggedUser);
            model.addAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.read());
            return new ModelAndView(PagesPathEnum.SHOP_PAGE.getPath(), model);
        } else {
            return new ModelAndView(PagesPathEnum.LOG_IN_PAGE.getPath());
        }
    }

    @ModelAttribute(EshopConstants.USER)
    public User setUpUser() {
        return new User();
    }
}
