package dev.javiervs.iteration3.validator;

import dev.javiervs.iteration3.password.LongPassword;
import dev.javiervs.iteration3.password.ShortPassword;

public class PasswordValidatorFactory {

    public static PasswordValidator create(String passwordTypeName) {
        if (LongPassword.class.getName().equals(passwordTypeName)) {
            return new LongPasswordValidator();
        } else if (ShortPassword.class.getName().equals(passwordTypeName)) {
            return new ShortPasswordValidator();
        } else {
            throw new IllegalArgumentException("Password type not supported");
        }
    }
}
