package dev.javiervs.iteration4.middlepassword;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.OneErrorStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiddlePasswordValidatorOneErrorStrategyTest {
    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.MIDDLE_PASSWORD);
        passwordValidator.setValidationStrategy(new OneErrorStrategy());
    }

    @Test
    void shouldFailValidateMiddlePasswordWithTwoErrors() {
        Password passwordWithLessThan8CharactersAndNoCaps = new Password("123456_");
        assertFalse(passwordValidator.validate(passwordWithLessThan8CharactersAndNoCaps));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithLessThanMinLength() {
        Password passwordWithLessThan8Characters = new Password("12345N_");
        assertTrue(passwordValidator.validate(passwordWithLessThan8Characters));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("1234567_");
        assertTrue(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithoutNumber() {
        Password passwordWithoutNumber = new Password("ABCDEFG_");
        assertTrue(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithoutUnderScore() {
        Password passwordWithoutLowerCaseLetter = new Password("1234567A");
        assertTrue(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("123456A_");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
