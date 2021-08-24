package ru.otus.exceptions;

public class NoSuchNominalValueExistsException extends RuntimeException {
    private static final String MESSAGE = "Номинал купюры не найден: %d";

    public NoSuchNominalValueExistsException() {
        super(MESSAGE);
    }

    public NoSuchNominalValueExistsException(int value) {
        super(String.format(MESSAGE, value));
    }

}
