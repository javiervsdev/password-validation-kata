package dev.javiervs.iteration4.validator.strategy.impl;

import dev.javiervs.iteration4.validator.error.ErrorMessage;
import dev.javiervs.iteration4.validator.strategy.ValidationStrategy;

import java.util.List;

public class OneErrorStrategy implements ValidationStrategy {

    private final int MIN_ERRORS_NUMBER = 1;

    @Override
    public boolean executeValidation(List<ErrorMessage> errors) {
        return errors.size() <= MIN_ERRORS_NUMBER;
    }
}
