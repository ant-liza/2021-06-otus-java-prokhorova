package ru.otus.atm;

import ru.otus.banknotes.Banknotable;
import ru.otus.exceptions.NoSuchNominalValueExistsException;

/**
 * Интерфейс предназначен для принятия наличных денег
 */
public interface BanknotesAcceptable {
    /**
     * Метод принятия банкноты
     * @param bankNote - любая банкнота
     */
    void acceptBanknotes(Banknotable bankNote) throws NoSuchNominalValueExistsException;
}
