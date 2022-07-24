package dev.javiervs.iteration2.password;

public class LongPassword extends Password {

    public LongPassword(String password) {
        super(password, 16);
    }

    public Boolean containsUnderscore() {
        return getPassword().chars().anyMatch(character -> character == '_');
    }
}
