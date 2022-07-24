package dev.javiervs.iteration3.validator;

import dev.javiervs.iteration3.Constants;
import dev.javiervs.iteration3.validator.error.ErrorMessage;
import dev.javiervs.iteration3.password.Password;
import dev.javiervs.iteration3.password.ShortPassword;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static dev.javiervs.iteration3.Constants.*;
import static dev.javiervs.iteration3.validator.error.ErrorTypeEnum.NO_NUMBER;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class ShortPasswordValidator implements PasswordValidator {

    @Override
    public List<ErrorMessage> validate(Password password) {
        return validations.stream()
                .map(validation -> validation.apply(password))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public static final Function<Password, Optional<ErrorMessage>> validateNumber = password ->
            ((ShortPassword) password).containsNumber()
                    ? empty()
                    : of(new ErrorMessage(
                            NO_NUMBER_ERROR_MESSAGE,
                            NO_NUMBER));

    private final List<Function<Password, Optional<ErrorMessage>>> validations = List.of(
            validateMinLength,
            validateCapitalLetter,
            validateLowerCaseLetter,
            validateNumber);
}
