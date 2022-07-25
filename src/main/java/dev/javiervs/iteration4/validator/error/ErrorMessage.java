package dev.javiervs.iteration4.validator.error;

import java.util.Objects;

public record ErrorMessage(String message, ErrorTypeEnum errorType) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return message.equals(that.message) && errorType == that.errorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, errorType);
    }
}