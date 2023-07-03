package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.CategoryService;
import by.teachmeskills.task2.services.UserService;
import by.teachmeskills.task2.services.impl.CategoryServiceImpl;
import by.teachmeskills.task2.services.impl.UserServiceImpl;
import by.teachmeskills.task2.validator.ValidatorUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class RegistrationCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return checkReceivedUser(request);
    }

    private String checkReceivedUser(HttpServletRequest request) {
        String email = request.getParameter(RequestParamsEnum.MAIL.getValue());
        String name = request.getParameter(RequestParamsEnum.NAME.getValue());
        String surname = request.getParameter(RequestParamsEnum.SURNAME.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        String repeatPassword = request.getParameter(RequestParamsEnum.REPEATPASSWORD.getValue());
        String date = request.getParameter(RequestParamsEnum.DATE.getValue());
        if (ValidatorUtils.validateRegistration(email, name, surname, password, repeatPassword)) {
            UserService userService = new UserServiceImpl();
            CategoryService categoryService = new CategoryServiceImpl();
            User user = userService.saveUserService(email, name, surname, password, date, 0);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute(RequestParamsEnum.CURRENT_USER.getValue(), user);
                request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.readService());
                return PagesPathEnum.SHOP_PAGE.getPath();
            } else {
                return PagesPathEnum.REGISTRATION_PAGE.getPath();
            }
        }
        return PagesPathEnum.REGISTRATION_PAGE.getPath();
    }
}
