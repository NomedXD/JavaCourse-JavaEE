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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationCommandImpl implements BaseCommand {
    private static final UserService userService = new UserServiceImpl();
    private static final CategoryService categoryService = new CategoryServiceImpl();
    private final static Logger logger = LoggerFactory.getLogger(RegistrationCommandImpl.class);

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
            User user = userService.create(new User(email, password, name, surname, parseDate(date), 0));
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute(RequestParamsEnum.CURRENT_USER.getValue(), user);
                request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), categoryService.read());
                return PagesPathEnum.SHOP_PAGE.getPath();
            } else {
                return PagesPathEnum.REGISTRATION_PAGE.getPath();
            }
        }
        return PagesPathEnum.REGISTRATION_PAGE.getPath();
    }

    private Date parseDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = format.parse(date);
            return parsedDate;
        } catch (ParseException e) {
            logger.error("Error while parse date. Most likely format is wrong");
            return parsedDate;
        }
    }
}
