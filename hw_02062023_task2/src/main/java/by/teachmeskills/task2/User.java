package by.teachmeskills.task2;

public class User {
    private int id;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private String currentBalance;

    public User(int id, String mail, String password, String name, String surname, String currentBalance) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.currentBalance = currentBalance;
    }

    public User() {
        this.id = -1;
        this.mail = "None";
        this.password = "None";
        this.name = "None";
        this.surname = "None";
        this.currentBalance = "None";
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
