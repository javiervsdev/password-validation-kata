package dev.javiervs.iteration4.validator;

import dev.javiervs.iteration4.validator.impl.LongPasswordValidator;
import dev.javiervs.iteration4.validator.impl.MiddlePasswordValidator;
import dev.javiervs.iteration4.validator.impl.ShortPasswordValidator;

import static dev.javiervs.iteration4.validator.PasswordValidatorEnum.*;

public class PasswordValidatorFactory {

    public static PasswordValidator create(PasswordValidatorEnum passwordTypeName) {
        if (LONG_PASSWORD.equals(passwordTypeName)) {
            return new LongPasswordValidator();
        } else if (MIDDLE_PASSWORD.equals(passwordTypeName)) {
            return new MiddlePasswordValidator();
        } else if (SHORT_PASSWORD.equals(passwordTypeName)) {
            return new ShortPasswordValidator();
        } else {
            throw new IllegalArgumentException("Password type not supported");
        }
    }
}
