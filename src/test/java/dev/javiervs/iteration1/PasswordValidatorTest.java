package dev.javiervs.iteration1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void shouldFailValidatePasswordWithLessThanCharacters() {
        String passwordWithLessThan8Characters = "1234aA_";
        assertFalse(passwordValidator.validate(passwordWithLessThan8Characters));
    }

    @Test
    void shouldFailValidatePasswordWithoutCapitalLetter() {
        String passwordWithoutCapitalLetter = "12345678a_";
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidatePasswordWithoutLowerCaseLetter() {
        String passwordWithoutLowerCaseLetter = "12345678A_";
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidatePasswordWithoutNumber() {
        String passwordWithoutNumber = "abcdEFGH_";
        assertFalse(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldFailValidatePasswordWithoutUnderscore() {
        String passwordWithoutUnderscore = "12345678Aa";
        assertFalse(passwordValidator.validate(passwordWithoutUnderscore));
    }

    @Test
    void shouldValidatePasswordWithAllRequirements() {
        String passwordWithAllRequirements = "12345678Aa_";
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}