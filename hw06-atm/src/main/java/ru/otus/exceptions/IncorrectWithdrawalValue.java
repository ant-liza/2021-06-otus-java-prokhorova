package ru.otus.exceptions;

public class IncorrectWithdrawalValue extends RuntimeException {
    private static final String MESSAGE = "Некорректная сумма для снятия";

    public IncorrectWithdrawalValue(int value) {
        super(MESSAGE + ": " + value);
    }
}
