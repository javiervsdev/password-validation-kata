package dev.javiervs.iteration3.password;

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

    public final int getMinLength() {
        return minLength;
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
