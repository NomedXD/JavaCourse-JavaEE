package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.User;

public interface UserService extends BaseService<User> {
    User getUserService(String mail, String password);

    User saveUserService(String email, String name, String surname, String password, String date, float balance);
}
