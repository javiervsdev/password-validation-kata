package dev.javiervs.iteration2;

import dev.javiervs.iteration2.password.ShortPassword;
import dev.javiervs.iteration2.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration2.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortPasswordValidatorTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(ShortPassword.class.getName());
    }

    @Test
    void shouldFailValidatePasswordWithLessThanMinLength() {
        ShortPassword passwordWithLessThan6Characters = new ShortPassword("123mN");
        assertFalse(passwordValidator.validate(passwordWithLessThan6Characters));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutCapitalLetter() {
        ShortPassword passwordWithoutCapitalLetter = new ShortPassword("123456a");
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutLowerCaseLetter() {
        ShortPassword passwordWithoutLowerCaseLetter = new ShortPassword("123456A");
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutNumber() {
        ShortPassword passwordWithoutNumber = new ShortPassword("abcDEF");
        assertFalse(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldValidateShortPasswordWithAllRequirements() {
        ShortPassword passwordWithAllRequirements = new ShortPassword("123456Aa");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}