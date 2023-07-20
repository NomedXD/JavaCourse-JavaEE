package by.teachmeskills.task2.services.impl;

import by.teachmeskills.task2.domain.User;
import by.teachmeskills.task2.repositories.UserRepository;
import by.teachmeskills.task2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User entity) {
        return userRepository.create(entity);
    }

    @Override
    public List<User> read() {
        return userRepository.read();
    }

    @Override
    public User update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserByCredentials(String mail, String password) {
        return userRepository.getUserByCredentials(mail, password);
    }
}
