package dev.javiervs.iteration2.password;

public class ShortPassword extends Password {

    public ShortPassword(String password) {
        super(password, 6);
    }

    public final Boolean containsNumber() {
        return getPassword().chars().anyMatch(Character::isDigit);
    }
}
