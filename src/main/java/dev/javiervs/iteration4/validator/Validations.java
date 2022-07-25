package dev.javiervs.iteration4.validator;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.error.ErrorMessage;

import java.util.Optional;
import java.util.function.Function;

import static dev.javiervs.iteration4.Constants.*;
import static dev.javiervs.iteration4.validator.error.ErrorTypeEnum.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Validations {

    public static Function<Password, Optional<ErrorMessage>> validateCapitalLetter = password ->
            password.containsCapitalLetter()
                    ? empty()
                    : of(new ErrorMessage(
                    NO_CAPS_ERROR_MESSAGE,
                    NO_CAPS));

    public static Function<Password, Optional<ErrorMessage>> validateLowerCaseLetter = password ->
            password.containsLowerCaseLetter()
                    ? empty()
                    : of(new ErrorMessage(
                    NO_LOWER_ERROR_MESSAGE,
                    NO_LOWER));

    public static final Function<Password, Optional<ErrorMessage>> validateNumber = password ->
            password.containsNumber()
                    ? empty()
                    : of(new ErrorMessage(
                    NO_NUMBER_ERROR_MESSAGE,
                    NO_NUMBER));

    public static final Function<Password, Optional<ErrorMessage>> validateUnderscore = password ->
            password.containsUnderscore()
                    ? empty()
                    : of(new ErrorMessage(
                    NO_UNDERSCORE_ERROR_MESSAGE,
                    NO_UNDERSCORE));
}
