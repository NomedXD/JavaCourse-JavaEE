package by.teachmeskills.task1;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(){
        this.login = "None";
        this.password = "None";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
