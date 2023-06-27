package by.teachmeskills.task2.domain;

import java.util.Date;

public class User {
    private int id;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private Date date;
    private float currentBalance;
    private String mobile;
    private String street;
    private String accommodationNumber;
    private String flatNumber;

    public User() {

    }

    public User(int id, String mail, String password, String name, String surname, Date date, float currentBalance, String mobile, String street, String accommodationNumber, String flatNumber) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.currentBalance = currentBalance;
        this.mobile = mobile;
        this.street = street;
        this.accommodationNumber = accommodationNumber;
        this.flatNumber = flatNumber;
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

    public float getCurrentBalance() {
        return currentBalance;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStreet() {
        return street;
    }

    public String getAccommodationNumber() {
        return accommodationNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }
}
