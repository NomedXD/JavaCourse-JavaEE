package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.enums.PagesPathEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import by.teachmeskills.task2.services.UserService;
import by.teachmeskills.task2.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserDataCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        String mobile = request.getParameter(RequestParamsEnum.MOBILE.getValue());
        String street = request.getParameter(RequestParamsEnum.STREET.getValue());
        String accommodationNumber = request.getParameter(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue());
        String flatNumber = request.getParameter(RequestParamsEnum.FLAT_NUMBER.getValue());
        params.put(RequestParamsEnum.MOBILE.getValue(), mobile);
        params.put(RequestParamsEnum.STREET.getValue(), street);
        params.put(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue(), accommodationNumber);
        params.put(RequestParamsEnum.FLAT_NUMBER.getValue(), flatNumber);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(RequestParamsEnum.CURRENT_USER.getValue());
        validateInputs(params, user);
        User updatedUser = new User(user.getId(), user.getMail(), user.getPassword(), user.getName(), user.getSurname(),
                user.getDate(), user.getCurrentBalance(), params.get(RequestParamsEnum.MOBILE.getValue()), params.get(RequestParamsEnum.STREET.getValue()),
                params.get(RequestParamsEnum.ACCOMMODATION_NUMBER.getValue()), params.get(RequestParamsEnum.FLAT_NUMBER.getValue()));
        UserService userService = new UserServiceImpl();
        user = userService.updateService(updatedUser);
        session.setAttribute(RequestParamsEnum.CURRENT_USER.getValue(), user);
        return PagesPathEnum.ACCOUNT_PAGE.getPath();
    }

    private void validateInputs(Map<String, String> params, User user) {
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
}
