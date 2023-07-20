package by.teachmeskills.task2.controllers;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.EshopConstants;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes({EshopConstants.USER})
@RequestMapping("/sneakers-shop")
public class AccountController {
    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public ModelAndView getAccountPage() {
        return new ModelAndView(PagesPathEnum.ACCOUNT_PAGE.getPath());
    }

    @PostMapping("/update-account")
    public ModelAndView updateAccountData(@ModelAttribute("updatedUserFields") User updatedUserFields, @SessionAttribute(EshopConstants.USER) User user) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestParamsEnum.MOBILE.getValue(), updatedUserFields.getMobile());
        params.put(RequestParamsEnum.STREET.getValue(), updatedUserFields.getStreet());
        params.put(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue(), updatedUserFields.getAccommodationNumber());
        params.put(RequestParamsEnum.FLAT_NUMBER.getValue(), updatedUserFields.getFlatNumber());
        setInputs(params, user);
        updatedUserFields = new User(user.getId(), user.getMail(), user.getPassword(), user.getName(), user.getSurname(),
                user.getDate(), user.getCurrentBalance(), params.get(RequestParamsEnum.MOBILE.getValue()), params.get(RequestParamsEnum.STREET.getValue()),
                params.get(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue()), params.get(RequestParamsEnum.FLAT_NUMBER.getValue()));
        ModelMap model = new ModelMap();
        user = userService.update(updatedUserFields);
        model.addAttribute(EshopConstants.USER, user);
        return new ModelAndView(PagesPathEnum.ACCOUNT_PAGE.getPath(), model);
    }

    private void setInputs(Map<String, String> params, User user) {
        for (var entry : params.entrySet()) {
            if (entry.getValue().equals("")) {
                switch (entry.getKey()) {
                    case "mobile" -> {
                        entry.setValue(user.getMobile());
                    }
                    case "street" -> {
                        entry.setValue(user.getStreet());
                    }
                    case "accommodationNumber" -> {
                        entry.setValue(user.getAccommodationNumber());
                    }
                    case "flatNumber" -> {
                        entry.setValue(user.getFlatNumber());
                    }
                }
            }
        }
    }

    @ModelAttribute("updatedUserFields")
    public User setUpUpdatedUser() {
        return new User();
    }
}
