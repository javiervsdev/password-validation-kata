package dev.javiervs.iteration4.validator;

import dev.javiervs.iteration4.password.Password;
import dev.javiervs.iteration4.validator.error.ErrorMessage;
import dev.javiervs.iteration4.validator.strategy.ValidationStrategy;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class PasswordValidator {

    protected ValidationStrategy strategy;

    public void setValidationStrategy(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(Password password) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is needed");
        }
        List<ErrorMessage> errorsFound = hasErrors(password);
        return strategy.executeValidation(errorsFound);
    }

    protected abstract List<Function<Password, Optional<ErrorMessage>>> getValidations();

    protected List<ErrorMessage> hasErrors(Password password) {
        return getValidations().stream()
                .map(validation -> validation.apply(password))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
