package dev.javiervs.iteration2;

import dev.javiervs.iteration2.password.LongPassword;
import dev.javiervs.iteration2.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration2.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongPasswordValidatorTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(LongPassword.class.getName());
    }

    @Test
    void shouldFailValidatePasswordWithLessThanMinLength() {
        LongPassword passwordWithLessThan16Characters = new LongPassword("abcdefghijklmN_");
        assertFalse(passwordValidator.validate(passwordWithLessThan16Characters));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutCapitalLetter() {
        LongPassword passwordWithoutCapitalLetter = new LongPassword("abcdefghijklmno_");
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutLowerCaseLetter() {
        LongPassword passwordWithoutLowerCaseLetter = new LongPassword("ABCDEFGHIJKLMNO_");
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutUnderscore() {
        LongPassword passwordWithoutUnderscore = new LongPassword("abcdefghIJKLMNOP");
        assertFalse(passwordValidator.validate(passwordWithoutUnderscore));
    }

    @Test
    void shouldValidateLongPasswordWithAllRequirements() {
        LongPassword passwordWithAllRequirements = new LongPassword("abcdefghIJKLMNOP_");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}