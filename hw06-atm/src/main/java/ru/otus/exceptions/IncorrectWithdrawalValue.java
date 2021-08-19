package ru.otus.exceptions;

public class IncorrectWithdrawalValue extends Exception {
    private static final String MESSAGE = "Некорректная сумма для снятия";

    public IncorrectWithdrawalValue() {
        super(MESSAGE);
    }
}
