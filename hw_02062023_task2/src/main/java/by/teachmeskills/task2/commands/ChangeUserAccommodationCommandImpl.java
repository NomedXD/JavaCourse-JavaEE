package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ChangeUserAccommodationCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String accommodationNumber = request.getParameter(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue());
        HttpSession session = request.getSession();
        User user = CRUDUtils.updateUserAccommodationNumberAddress((User) session.getAttribute(RequestParamsEnum.CURRENT_USER.getValue()), accommodationNumber);
        session.setAttribute(RequestParamsEnum.CURRENT_USER.getValue(), user);
        return PagesPathEnum.ACCOUNT_PAGE.getPath();
    }
}
