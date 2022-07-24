package dev.javiervs.iteration3.password;

import dev.javiervs.iteration3.Constants;

import static dev.javiervs.iteration3.Constants.MIN_LENGTH_SHORT_PASSWORD;

public class ShortPassword extends Password {

    public ShortPassword(String password) {
        super(password, MIN_LENGTH_SHORT_PASSWORD);
    }

    public final Boolean containsNumber() {
        return getPassword().chars().anyMatch(Character::isDigit);
    }
}
