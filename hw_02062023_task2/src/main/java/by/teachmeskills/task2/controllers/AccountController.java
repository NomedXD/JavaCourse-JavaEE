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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({EshopConstants.USER})
@RequestMapping("/account")
public class AccountController {
    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getAccountPage() {
        return new ModelAndView(PagesPathEnum.ACCOUNT_PAGE.getPath());
    }

    @PostMapping("/update")
    public ModelAndView updateAccountData(@ModelAttribute("updatedUserFields") User updatedUserFields, @SessionAttribute(EshopConstants.USER) User user) {
        return userService.updateAccountData(updatedUserFields, user);
    }

    @ModelAttribute("updatedUserFields")
    public User setUpUpdatedUser() {
        return new User();
    }
}
