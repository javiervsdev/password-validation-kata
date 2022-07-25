package dev.javiervs.iteration4.validator.impl;

import dev.javiervs.iteration4.Constants;
import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.PasswordValidator;
import dev.javiervs.iteration4.validator.error.ErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static dev.javiervs.iteration4.Constants.*;
import static dev.javiervs.iteration4.validator.Validations.*;
import static dev.javiervs.iteration4.validator.error.ErrorTypeEnum.NO_MIN_LENGTH;
import static java.lang.String.format;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class MiddlePasswordValidator extends PasswordValidator {

    int minLength = MIN_LENGTH_MIDDLE_PASSWORD;
    @Override
    protected List<Function<Password, Optional<ErrorMessage>>> getValidations() {
        return List.of(
                validateMinLength,
                validateCapitalLetter,
                validateNumber,
                validateUnderscore);
    }

    private final Function<Password, Optional<ErrorMessage>> validateMinLength = password ->
            password.containsAtLeastMinLength(minLength)
                    ? empty()
                    : of(new ErrorMessage(
                    format(
                            NO_MIN_LENGTH_ERROR_MESSAGE,
                            minLength),
                    NO_MIN_LENGTH));
}
