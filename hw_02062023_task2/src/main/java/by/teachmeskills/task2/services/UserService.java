package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.User;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseService<User> {
    User getUserByCredentials(String mail, String password);

    ModelAndView updateAccountData(User updatedUserFields, User user);

    ModelAndView logIn(User user);

    ModelAndView register(User user, String repeatPassword);

    ModelAndView checkIfLoggedInUser(User user);
}
