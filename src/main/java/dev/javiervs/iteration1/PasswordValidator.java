package dev.javiervs.iteration1;

import java.util.function.Predicate;

public class PasswordValidator {
    public boolean validate(String password) {
        return containsAtLeast8Characters
                .and(containsCapitalLetter)
                .and(containsLowerCaseLetter)
                .and(containsNumber)
                .and(containsUnderscore)
                .test(password);
    }

    private final Predicate<String> containsAtLeast8Characters =
            (password) -> password.length() >= 8;

    private final Predicate<String> containsCapitalLetter =
            (password) -> password.chars().anyMatch(Character::isUpperCase);

    private final Predicate<String> containsLowerCaseLetter =
            (password) -> password.chars().anyMatch(Character::isLowerCase);

    private final Predicate<String> containsNumber =
            (password) -> password.chars().anyMatch(Character::isDigit);

    private final Predicate<String> containsUnderscore =
            (password) -> password.chars().anyMatch(character -> character == '_');
}
