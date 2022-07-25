package dev.javiervs.iteration4.validator.strategy;

import dev.javiervs.iteration4.validator.error.ErrorMessage;

import java.util.List;

public interface ValidationStrategy {
    boolean executeValidation(List<ErrorMessage> errors);
}
