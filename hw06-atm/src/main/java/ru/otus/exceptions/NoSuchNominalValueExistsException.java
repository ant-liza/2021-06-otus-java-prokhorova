package ru.otus.exceptions;

public class NoSuchNominalValueExistsException extends Exception {
    private static final String MESSAGE = "Номинал купюры не найден";
    public NoSuchNominalValueExistsException() {
        super(MESSAGE);
    }
}
