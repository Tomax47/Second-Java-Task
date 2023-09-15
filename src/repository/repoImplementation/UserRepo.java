package repository.repoImplementation;

import model.User;
import repository.UserInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements UserInterface<User> {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/users";

    private static final String SELECT_ALL = "SELECT * FROM accounts";
    private static final String SELECT_BY_AGE = "SELECT * FROM accounts WHERE age=?";

    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

    public void save(User model) {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
            Statement statement = connection.createStatement();
            try {
                ResultSet result = statement.executeQuery(SELECT_ALL);


                String sqlInsertUser = "INSERT INTO accounts(first_name, surname, age) VALUES(?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
                preparedStatement.setString(1, model.getFirst_name());
                preparedStatement.setString(2, model.getSurname());
                preparedStatement.setInt(3,model.getAge());

                int affectedRows = preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userID) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setInt(1, userID);
            
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> findByAge(int age) {
        List<User> usersByAge = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_AGE);
            preparedStatement.setInt(1, age);

            try {
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    User user = new User(result.getInt("id")
                            ,result.getString("first_name")
                            ,result.getString("surname")
                            ,result.getInt("age"));

                    usersByAge.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return usersByAge;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
            Statement statement = connection.createStatement();

            try {
                ResultSet result = statement.executeQuery(SELECT_ALL);
                while (result.next()) {
                    User user = new User(result.getInt("id")
                            ,result.getString("first_name")
                            ,result.getString("surname")
                            ,result.getInt("age"));

                    allUsers.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return allUsers;
    }
}
