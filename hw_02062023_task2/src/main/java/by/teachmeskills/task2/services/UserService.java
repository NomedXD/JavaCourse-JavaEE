package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.User;

public interface UserService extends BaseService<User> {
    User getUserByCredentials(String mail, String password);
}
