package dev.javiervs.iteration4.middlepassword;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.NoErrorsStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiddlePasswordValidatorNoErrorsStrategyTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.MIDDLE_PASSWORD);
        passwordValidator.setValidationStrategy(new NoErrorsStrategy());
    }

    @Test
    void shouldFailValidateMiddlePasswordWithLessThanMinLength() {
        Password passwordWithLessThan8Characters = new Password("12345N_");
        assertFalse(passwordValidator.validate(passwordWithLessThan8Characters));
    }

    @Test
    void shouldFailValidateMiddlePasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("1234567_");
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateMiddlePasswordWithoutNumber() {
        Password passwordWithoutNumber = new Password("ABCDEFG_");
        assertFalse(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldFailValidateMiddlePasswordWithoutUnderScore() {
        Password passwordWithoutLowerCaseLetter = new Password("1234567A");
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldSuccessValidateMiddlePasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("123456A_");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
