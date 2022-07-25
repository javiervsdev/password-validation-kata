package dev.javiervs.iteration4.longpassword;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.OneErrorStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongPasswordValidatorOneErrorStrategyTest {
    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.LONG_PASSWORD);
        passwordValidator.setValidationStrategy(new OneErrorStrategy());
    }

    @Test
    void shouldFailValidateLongPasswordWithTwoErrors() {
        Password passwordWithLessThan16CharactersAndNoCaps = new Password("abcdefghijklmn_");
        assertFalse(passwordValidator.validate(passwordWithLessThan16CharactersAndNoCaps));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithLessThanMinLength() {
        Password passwordWithLessThan16Characters = new Password("abcdefghijklmN_");
        assertTrue(passwordValidator.validate(passwordWithLessThan16Characters));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("abcdefghijklmno_");
        assertTrue(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithoutLowerCaseLetter() {
        Password passwordWithoutLowerCaseLetter = new Password("ABCDEFGHIJKLMNO_");
        assertTrue(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithoutUnderscore() {
        Password passwordWithoutUnderscore = new Password("abcdefghIJKLMNOP");
        assertTrue(passwordValidator.validate(passwordWithoutUnderscore));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("abcdefghIJKLMNOP_");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
