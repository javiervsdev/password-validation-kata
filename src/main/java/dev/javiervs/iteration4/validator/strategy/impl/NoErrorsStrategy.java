package dev.javiervs.iteration4.validator.strategy.impl;

import dev.javiervs.iteration4.validator.error.ErrorMessage;
import dev.javiervs.iteration4.validator.strategy.ValidationStrategy;

import java.util.Collection;
import java.util.List;

public class NoErrorsStrategy implements ValidationStrategy {

    @Override
    public boolean executeValidation(List<ErrorMessage> errors) {
        return errors.isEmpty();
    }
}
