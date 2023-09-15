package api;

import model.User;
import repository.repoImplementation.UserRepo;

import java.util.List;

public class v1 {

    private final UserRepo userrepo;

    public v1(UserRepo UR) {
        this.userrepo = UR;
    }


    public void saveUser(User model) {
        try {
            userrepo.save(model);
            System.out.println("User has been saved successfully!");
        } catch (Exception e) {
            System.out.print("Can't save user due to the Error : ");
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id) {
        try {
            deleteUserById(id);
            System.out.println("User has been deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong, couldn't delete the user!");
        }
    }


    public void findAllUsers() {
        List<User> allUsers = userrepo.findAll();

        if (allUsers.size() > 0) {
            for (User user : allUsers) {
                System.out.println("id : " + user.getId()
                        + " | name : " + user.getFirst_name()
                        + " | surname : " + user.getSurname()
                        + " | age : " + user.getAge());
            }

        } else {
            System.out.println("No users found by the provided age!");
        }
    }


    public void findUsersByAge(int age) {
        List<User> usersByAge = userrepo.findByAge(age);

        if (usersByAge.size() > 0) {
            for (User user : usersByAge) {
                System.out.println("id : " + user.getId()
                        + " | name : " + user.getFirst_name()
                        + " | surname : " + user.getSurname()
                        + " | age : " + user.getAge());
            }

        } else {
            System.out.println("No users found by the provided age "+age+"!");
        }

    }

}
