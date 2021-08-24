package ru.otus.exceptions;

public class IncorrectWithdrawalValue extends RuntimeException {
    private static final String MESSAGE = "Некорректная сумма для снятия: %d";

    public IncorrectWithdrawalValue(int value) {
        super(String.format(MESSAGE, value));
    }
}
