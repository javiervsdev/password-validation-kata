package dev.javiervs.iteration2.password;

import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Password {

    private final String password;
    private final int minLength;

    public Password(String password, int minLength) {
        this.password = password;
        this.minLength = minLength;
    }

    public final String getPassword() {
        return password;
    }

    public final Boolean containsAtLeastMinLength() {
        return password.length() >= minLength;
    }

    public final Boolean containsCapitalLetter() {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    public final Boolean containsLowerCaseLetter() {
        return password.chars().anyMatch(Character::isLowerCase);
    }

}
