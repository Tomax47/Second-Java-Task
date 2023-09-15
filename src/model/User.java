package model;

public class User {
    private long id;
    private String first_name;
    private String surname;
    private int age;

    public User(long id, String first_name, String surname, int age) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.age = age;
    }

    public User(String first_name, String surname, int age) {
        this.first_name = first_name;
        this.surname = surname;
        this.age = age;
    }

    public User() {}


    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
