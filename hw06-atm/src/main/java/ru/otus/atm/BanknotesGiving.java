package ru.otus.atm;

import ru.otus.banknotes.Banknotable;
import ru.otus.exceptions.IncorrectWithdrawalValue;
import ru.otus.exceptions.NoSuchNominalValueExistsException;

import java.util.List;

/**
 * Интерфейс предназначен для выдачи наличных денег
 */
public interface BanknotesGiving {
    /**
     * Снятие наличных
     * @param value - сколько надо выдать?
     * @return - список банкнот, которые будет выдававть банкомат
     */
    List<Banknotable> makeWithdrawal(int value) throws NoSuchNominalValueExistsException, IncorrectWithdrawalValue;
}
