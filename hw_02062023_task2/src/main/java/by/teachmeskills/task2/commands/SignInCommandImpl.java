package by.teachmeskills.task2.commands;


import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SignInCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return checkReceivedUser(request);
    }

    private String checkReceivedUser(HttpServletRequest request) {
        String mail = request.getParameter(RequestParamsEnum.MAIL.getValue());
        String password = request.getParameter(RequestParamsEnum.PASSWORD.getValue());
        User user = CRUDUtils.getUser(mail, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(RequestParamsEnum.CURRENT_USER.getValue(), user);
            request.setAttribute(RequestParamsEnum.CATEGORIES.getValue(), CRUDUtils.getAllCategories());
            return PagesPathEnum.SHOP_PAGE.getPath();
        } else {
            return PagesPathEnum.LOG_IN_PAGE.getPath();
        }

    }
}
