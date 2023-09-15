import api.v1;
import model.User;
import repository.repoImplementation.UserRepo;

public class Main {


    public static void main(String[] args) throws Exception {

        UserRepo userRepo = new UserRepo();

        v1 api = new v1(userRepo);

        //User user = new User("Mickey", "Nuke", 33);
        //api.saveUser(user);

        System.out.println("\nAll users : ");
        api.findAllUsers();

        System.out.println("\nUsers by the age : ");
        api.findUsersByAge(22);

        System.out.println("\n");
        api.deleteUserById(2);

    }
}