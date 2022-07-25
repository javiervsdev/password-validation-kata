package dev.javiervs.iteration4.shortpassword;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.OneErrorStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPasswordValidatorOneErrorStrategyTest {
    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.SHORT_PASSWORD);
        passwordValidator.setValidationStrategy(new OneErrorStrategy());
    }

    @Test
    void shouldFailValidateShortPasswordWithTwoErrors() {
        Password passwordWithLessThan6CharactersAndNoCaps = new Password("123mn");
        assertFalse(passwordValidator.validate(passwordWithLessThan6CharactersAndNoCaps));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithLessThanMinLength() {
        Password passwordWithLessThan6Characters = new Password("123mN");
        assertTrue(passwordValidator.validate(passwordWithLessThan6Characters));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("123456a");
        assertTrue(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithoutLowerCaseLetter() {
        Password passwordWithoutLowerCaseLetter = new Password("123456A");
        assertTrue(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithoutNumber() {
        Password passwordWithoutNumber = new Password("abcDEF");
        assertTrue(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("123456Aa");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
