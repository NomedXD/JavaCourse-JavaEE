package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.repositories.UserRepository;
import by.teachmeskills.task2.repositories.impl.UserRepositoryImpl;
import by.teachmeskills.task2.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User createService(User entity) {
        return null;
    }

    @Override
    public List<User> readService() {
        return null;
    }

    @Override
    public User updateService(User entity) {
       return userRepository.update(entity);
    }

    @Override
    public void deleteService(int id) {

    }

    @Override
    public User getUserService(String mail, String password) {
       return userRepository.getUser(mail,password);
    }

    @Override
    public User saveUserService(String email, String name, String surname, String password, String date, float balance) {
       return userRepository.saveUser(email,name,surname,password,date,balance);
    }
}
