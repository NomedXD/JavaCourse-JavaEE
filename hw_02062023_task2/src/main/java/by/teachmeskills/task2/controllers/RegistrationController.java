package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.enums.PagesPathEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sneakers-shop")
public class RegistrationController {
    @GetMapping("/register")
    public ModelAndView getLoginPage() {
        return new ModelAndView(PagesPathEnum.REGISTRATION_PAGE.getPath());
    }
}
