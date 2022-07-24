package dev.javiervs.iteration2.validator;

import dev.javiervs.iteration2.password.Password;

public interface PasswordValidator {
    boolean validate(Password password);
}
