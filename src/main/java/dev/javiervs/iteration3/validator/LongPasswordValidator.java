package dev.javiervs.iteration3.validator;

import dev.javiervs.iteration3.Constants;
import dev.javiervs.iteration3.validator.error.ErrorMessage;
import dev.javiervs.iteration3.password.LongPassword;
import dev.javiervs.iteration3.password.Password;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static dev.javiervs.iteration3.Constants.*;
import static dev.javiervs.iteration3.validator.error.ErrorTypeEnum.NO_UNDERSCORE;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class LongPasswordValidator implements PasswordValidator {

    @Override
    public List<ErrorMessage> validate(Password password) {
        return validations.stream()
                .map(validation -> validation.apply(password))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public static final Function<Password, Optional<ErrorMessage>> validateUnderscore = password ->
            ((LongPassword) password).containsUnderscore()
                    ? empty()
                    : of(new ErrorMessage(
                            NO_UNDERSCORE_ERROR_MESSAGE,
                            NO_UNDERSCORE));

    private final List<Function<Password, Optional<ErrorMessage>>> validations = List.of(
            validateMinLength,
            validateCapitalLetter,
            validateLowerCaseLetter,
            validateUnderscore);
}
