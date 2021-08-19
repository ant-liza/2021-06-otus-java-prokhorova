package ru.otus.atm;

import ru.otus.banknotes.Banknotable;

import java.util.List;

/**
 * Общий интерфейс для любых банкоматов
 */
public interface CashMachinable extends BanknotesAcceptable, BanknotesGiving {
    /**
     * Метод для получения остатка средств в банкомате
     * @return - остаток денежных средств
     */
    int getCashBalanceLeft();

    /**
     * Метод для пересчета остатка банкнот после выдачи
     */
    void recalculateBanknotesLeftOversAfterWithdrawal(List<Banknotable> listOfBanknotesForGivingAway);
}
