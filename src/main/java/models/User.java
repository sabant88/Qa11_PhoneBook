package models;

public class User {
    String eMail;
    String password;

    public User setWithMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
