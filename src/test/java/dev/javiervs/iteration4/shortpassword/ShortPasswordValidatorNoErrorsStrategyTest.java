package dev.javiervs.iteration4.shortpassword;

import dev.javiervs.iteration2.password.ShortPassword;
import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.PasswordValidatorEnum;
import dev.javiervs.iteration4.validator.strategy.impl.NoErrorsStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static dev.javiervs.iteration4.validator.PasswordValidatorFactory.create;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPasswordValidatorNoErrorsStrategyTest {

    private static PasswordValidator passwordValidator;

    @BeforeAll
    static void setUp() {
        passwordValidator = create(PasswordValidatorEnum.SHORT_PASSWORD);
        passwordValidator.setValidationStrategy(new NoErrorsStrategy());
    }

    @Test
    void shouldFailValidateShortPasswordWithLessThanMinLength() {
        Password passwordWithLessThan6Characters = new Password("123mN");
        assertFalse(passwordValidator.validate(passwordWithLessThan6Characters));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutCapitalLetter() {
        Password passwordWithoutCapitalLetter = new Password("123456a");
        assertFalse(passwordValidator.validate(passwordWithoutCapitalLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutLowerCaseLetter() {
        Password passwordWithoutLowerCaseLetter = new Password("123456A");
        assertFalse(passwordValidator.validate(passwordWithoutLowerCaseLetter));
    }

    @Test
    void shouldFailValidateShortPasswordWithoutNumber() {
        Password passwordWithoutNumber = new Password("abcDEF");
        assertFalse(passwordValidator.validate(passwordWithoutNumber));
    }

    @Test
    void shouldSuccessValidateShortPasswordWithAllRequirements() {
        Password passwordWithAllRequirements = new Password("123456Aa");
        assertTrue(passwordValidator.validate(passwordWithAllRequirements));
    }
}
