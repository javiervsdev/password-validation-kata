package dev.javiervs.iteration4.longpassword;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.NoErrorsStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongPasswordValidatorNoErrorsStrategyTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.LONG_PASSWORD);
        passwordValidator.setValidationStrategy(new NoErrorsStrategy());
    }

    @Test
    void shouldFailValidateLongPasswordWithLessThanMinLength() {
        Password passwordWithLessThan16Characters = new Password("abcdefghijklmN_");
        assertFalse(passwordValidator.validate(passwordWithLessThan16Characters));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("abcdefghijklmno_");
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutLowerCaseLetter() {
        Password passwordWithoutLowerCaseLetter = new Password("ABCDEFGHIJKLMNO_");
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateLongPasswordWithoutUnderscore() {
        Password passwordWithoutUnderscore = new Password("abcdefghIJKLMNOP");
        assertFalse(passwordValidator.validate(passwordWithoutUnderscore));
    }

    @Test
    void shouldSuccessValidateLongPasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("abcdefghIJKLMNOP_");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
