package dev.javiervs.iteration2.validator;

import dev.javiervs.iteration2.password.LongPassword;
import dev.javiervs.iteration2.password.Password;

public class LongPasswordValidator implements PasswordValidator {

    @Override
    public boolean validate(Password password) {
        LongPassword longPassword = (LongPassword) password;
        return longPassword.containsAtLeastMinLength()
                && longPassword.containsCapitalLetter()
                && longPassword.containsLowerCaseLetter()
                && longPassword.containsUnderscore();
    }
}
