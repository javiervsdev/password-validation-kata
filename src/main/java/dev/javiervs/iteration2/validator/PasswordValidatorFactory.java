package dev.javiervs.iteration2.validator;

import dev.javiervs.iteration2.password.LongPassword;
import dev.javiervs.iteration2.password.Password;
import dev.javiervs.iteration2.password.ShortPassword;

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
