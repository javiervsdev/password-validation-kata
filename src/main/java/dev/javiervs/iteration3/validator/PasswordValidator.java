package dev.javiervs.iteration3.validator;

import dev.javiervs.iteration3.Constants;
import dev.javiervs.iteration3.validator.error.ErrorMessage;
import dev.javiervs.iteration3.password.Password;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static dev.javiervs.iteration3.Constants.*;
import static dev.javiervs.iteration3.validator.error.ErrorTypeEnum.*;
import static java.lang.String.*;
import static java.util.Optional.*;

public interface PasswordValidator {
    List<ErrorMessage> validate(Password password);

    Function<Password, Optional<ErrorMessage>> validateMinLength = password ->
            password.containsAtLeastMinLength()
                    ? empty()
                    : of(new ErrorMessage(
                            format(
                                    NO_MIN_LENGTH_ERROR_MESSAGE,
                                    password.getMinLength()),
                            NO_MIN_LENGTH));

    Function<Password, Optional<ErrorMessage>> validateCapitalLetter = password ->
            password.containsCapitalLetter()
                    ? empty()
                    : of(new ErrorMessage(
                            NO_CAPS_ERROR_MESSAGE,
                            NO_CAPS));

    Function<Password, Optional<ErrorMessage>> validateLowerCaseLetter = password ->
            password.containsLowerCaseLetter()
                    ? empty()
                    : of(new ErrorMessage(
                            NO_LOWER_ERROR_MESSAGE,
                            NO_LOWER));
}
