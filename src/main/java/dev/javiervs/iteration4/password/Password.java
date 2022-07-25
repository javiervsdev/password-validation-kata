package dev.javiervs.iteration4.password;

public class Password {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public final String getPassword() {
        return password;
    }

    public final Boolean containsAtLeastMinLength(int minLength) {
        return password.length() >= minLength;
    }

    public final Boolean containsCapitalLetter() {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    public final Boolean containsLowerCaseLetter() {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    public final Boolean containsNumber() {
        return getPassword().chars().anyMatch(Character::isDigit);
    }

    public Boolean containsUnderscore() {
        return getPassword().chars().anyMatch(character -> character == '_');
    }

}
