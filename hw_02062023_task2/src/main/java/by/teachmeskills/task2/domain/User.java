package by.teachmeskills.task2.domain;

import java.util.Date;

public class User {
    private int id;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private Date date;
    private String currentBalance;

    public User() {

    }

    public User(int id, String mail, String password, String name, String surname, Date date, String currentBalance) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDate() {
        return date;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }
}
