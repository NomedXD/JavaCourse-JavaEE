package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.CategoryService;
import by.teachmeskills.task2.services.UserService;
import by.teachmeskills.task2.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({EshopConstants.USER})
@RequestMapping("/sneakers-shop")
public class RegistrationController {
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public RegistrationController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/register")
    public ModelAndView getRegistrationPage() {
        return new ModelAndView(PagesPathEnum.REGISTRATION_PAGE.getPath());
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute(EshopConstants.USER) User user, @RequestParam(name = "repeatPasswordParam") String repeatPassword) {
        if (ValidatorUtils.validateRegistration(user.getMail(), user.getName(), user.getSurname(), user.getPassword(), repeatPassword)) {
            ModelMap model = new ModelMap();
            User loggedUser = userService.create(new User(user.getMail(), user.getPassword(), user.getName(), user.getSurname(), user.getDate(), 0));
            if (loggedUser != null) {
                model.addAttribute(EshopConstants.USER, loggedUser);
                model.addAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.read());
                return new ModelAndView(PagesPathEnum.SHOP_PAGE.getPath(), model);
            } else {
                return new ModelAndView(PagesPathEnum.REGISTRATION_PAGE.getPath());
            }
        }
        return new ModelAndView(PagesPathEnum.REGISTRATION_PAGE.getPath());
    }

    @ModelAttribute(EshopConstants.USER)
    public User setUpUser() {
        return new User();
    }
}
