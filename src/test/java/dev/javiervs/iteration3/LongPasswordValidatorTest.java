package dev.javiervs.iteration3;

import dev.javiervs.iteration3.password.LongPassword;
import dev.javiervs.iteration3.validator.PasswordValidator;
import dev.javiervs.iteration3.validator.error.ErrorMessage;
import dev.javiervs.iteration3.validator.error.ErrorTypeEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dev.javiervs.iteration3.Constants.*;
import static dev.javiervs.iteration3.Constants.MIN_LENGTH_LONG_PASSWORD;
import static dev.javiervs.iteration3.validator.PasswordValidatorFactory.create;
import static dev.javiervs.iteration3.validator.error.ErrorTypeEnum.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class LongPasswordValidatorTest {

    private static PasswordValidator passwordValidator;
    private static ErrorMessage NO_MIN_LENGTH_ERROR;
    private static ErrorMessage NO_CAPS_ERROR;
    private static ErrorMessage NO_LOWER_ERROR;
    private static ErrorMessage NO_UNDERSCORE_ERROR;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(LongPassword.class.getName());
        NO_MIN_LENGTH_ERROR = new ErrorMessage(
                            format(
                                    NO_MIN_LENGTH_ERROR_MESSAGE,
                                    MIN_LENGTH_LONG_PASSWORD),
                            NO_MIN_LENGTH);
        NO_CAPS_ERROR = new ErrorMessage(
                NO_CAPS_ERROR_MESSAGE,
                NO_CAPS);
        NO_LOWER_ERROR = new ErrorMessage(
                NO_LOWER_ERROR_MESSAGE,
                NO_LOWER);
        NO_UNDERSCORE_ERROR = new ErrorMessage(
                NO_UNDERSCORE_ERROR_MESSAGE,
                NO_UNDERSCORE);
    }

    @Test
    void shouldFailValidatePasswordWithLessThanMinLength() {
        LongPassword passwordWithLessThan16Characters = new LongPassword("abcdefghijklmN_");
        assertIterableEquals(
                List.of(NO_MIN_LENGTH_ERROR),
                passwordValidator.validate(passwordWithLessThan16Characters));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutCapitalLetter() {
        LongPassword passwordWithoutCapitalLetter = new LongPassword("abcdefghijklmno_");
        assertIterableEquals(
                List.of(NO_CAPS_ERROR),
                passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutLowerCaseLetter() {
        LongPassword passwordWithoutLowerCaseLetter = new LongPassword("ABCDEFGHIJKLMNO_");
        assertIterableEquals(
                List.of(NO_LOWER_ERROR),
                passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutUnderscore() {
        LongPassword passwordWithoutUnderscore = new LongPassword("abcdefghIJKLMNOP");
        assertIterableEquals(
                List.of(NO_UNDERSCORE_ERROR),
                passwordValidator.validate(passwordWithoutUnderscore));
    }

    @Test
    void shouldFailValidateLongPasswordAllErrors() {
        LongPassword passwordWithAllErrors = new LongPassword("");
        assertIterableEquals(
                List.of(NO_MIN_LENGTH_ERROR, NO_CAPS_ERROR, NO_LOWER_ERROR, NO_UNDERSCORE_ERROR),
                passwordValidator.validate(passwordWithAllErrors));
    }

    @Test
    void shouldValidateLongPasswordWithAllRequirements() {
        List<ErrorMessage> emptyList = new ArrayList<>();
        LongPassword passwordWithAllRequirements = new LongPassword("abcdefghIJKLMNOP_");
        assertIterableEquals(emptyList, passwordValidator.validate(passwordWithAllRequirements));
    }
}