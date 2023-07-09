package by.teachmeskills.task2.repositories;

import by.teachmeskills.task2.domain.User;

public interface UserRepository extends BaseRepository<User>{
    User getUserByCredentials(String mail, String password);
}
