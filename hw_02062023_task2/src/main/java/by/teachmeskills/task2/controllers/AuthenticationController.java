package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({EshopConstants.USER})
@RequestMapping("/login")
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getLoginPage() {
        return new ModelAndView(PagesPathEnum.LOG_IN_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView logIn(@ModelAttribute(EshopConstants.USER) User user) {
        return userService.logIn(user);
    }

    @ModelAttribute(EshopConstants.USER)
    public User setUpUser() {
        return new User();
    }
}
