package dev.javiervs.iteration2.validator;

import dev.javiervs.iteration2.password.Password;
import dev.javiervs.iteration2.password.ShortPassword;

public class ShortPasswordValidator implements PasswordValidator {

    @Override
    public boolean validate(Password password) {
        ShortPassword shortPassword = (ShortPassword) password;
        return shortPassword.containsAtLeastMinLength()
                && shortPassword.containsCapitalLetter()
                && shortPassword.containsLowerCaseLetter()
                && shortPassword.containsNumber();
    }
}
