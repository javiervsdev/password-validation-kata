package dev.javiervs.iteration3;

import dev.javiervs.iteration3.password.ShortPassword;
import dev.javiervs.iteration3.validator.PasswordValidator;
import dev.javiervs.iteration3.validator.error.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dev.javiervs.iteration3.Constants.*;
import static dev.javiervs.iteration3.validator.PasswordValidatorFactory.create;
import static dev.javiervs.iteration3.validator.error.ErrorTypeEnum.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ShortPasswordValidatorTest {

    private static PasswordValidator passwordValidator;
    private static ErrorMessage NO_MIN_LENGTH_ERROR;
    private static ErrorMessage NO_CAPS_ERROR;
    private static ErrorMessage NO_LOWER_ERROR;
    private static ErrorMessage NO_NUMBER_ERROR;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(ShortPassword.class.getName());
        NO_MIN_LENGTH_ERROR = new ErrorMessage(
                            format(
                                    NO_MIN_LENGTH_ERROR_MESSAGE,
                                    MIN_LENGTH_SHORT_PASSWORD),
                            NO_MIN_LENGTH);
        NO_CAPS_ERROR = new ErrorMessage(
                NO_CAPS_ERROR_MESSAGE,
                NO_CAPS);
        NO_LOWER_ERROR = new ErrorMessage(
                NO_LOWER_ERROR_MESSAGE,
                NO_LOWER);
        NO_NUMBER_ERROR = new ErrorMessage(
                NO_NUMBER_ERROR_MESSAGE,
                NO_NUMBER);
    }

    @Test
    void shouldFailValidatePasswordWithLessThanMinLength() {
        ShortPassword passwordWithLessThan6Characters = new ShortPassword("123mN");
        assertIterableEquals(
                List.of(NO_MIN_LENGTH_ERROR),
                passwordValidator.validate(passwordWithLessThan6Characters));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutCapitalLetter() {
        ShortPassword passwordWithoutCapitalLetter = new ShortPassword("123456a");
        assertIterableEquals(
                List.of(NO_CAPS_ERROR),
                passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutLowerCaseLetter() {
        ShortPassword passwordWithoutLowerCaseLetter = new ShortPassword("123456A");
        assertIterableEquals(
                List.of(NO_LOWER_ERROR),
                passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutNumber() {
        ShortPassword passwordWithoutNumber = new ShortPassword("abcDEF");
        assertIterableEquals(
                List.of(NO_NUMBER_ERROR),
                passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldFailValidateShortPasswordAllErrors() {
        ShortPassword passwordWithAllErrors = new ShortPassword("");
        assertIterableEquals(
                List.of(NO_MIN_LENGTH_ERROR, NO_CAPS_ERROR, NO_LOWER_ERROR, NO_NUMBER_ERROR),
                passwordValidator.validate(passwordWithAllErrors));
    }

    @Test
    void shouldValidateShortPasswordWithAllRequirements() {
        List<ErrorMessage> emptyList = new ArrayList<>();
        ShortPassword passwordWithAllRequirements = new ShortPassword("123456Aa");
        assertIterableEquals(emptyList, passwordValidator.validate(passwordWithAllRequirements));
    }
}