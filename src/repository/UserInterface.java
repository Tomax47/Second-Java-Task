package repository;

import java.util.List;

public interface UserInterface <User> {

    List<User> findByAge(int age);

    List<User> findAll();

//    void deleteUser(int userID);
}
