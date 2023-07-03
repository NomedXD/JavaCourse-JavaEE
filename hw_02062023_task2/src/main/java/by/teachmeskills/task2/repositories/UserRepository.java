package by.teachmeskills.task2.repositories;

import by.teachmeskills.task2.domain.User;

public interface UserRepository extends BaseRepository<User>{
    User getUser(String mail, String password);
    User saveUser(String email, String name, String surname, String password, String date, float balance);
}
