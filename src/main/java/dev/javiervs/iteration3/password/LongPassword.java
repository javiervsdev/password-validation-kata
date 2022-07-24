package dev.javiervs.iteration3.password;

import dev.javiervs.iteration3.Constants;

import static dev.javiervs.iteration3.Constants.MIN_LENGTH_LONG_PASSWORD;

public class LongPassword extends Password {

    public LongPassword(String password) {
        super(password, MIN_LENGTH_LONG_PASSWORD);
    }

    public Boolean containsUnderscore() {
        return getPassword().chars().anyMatch(character -> character == '_');
    }
}
