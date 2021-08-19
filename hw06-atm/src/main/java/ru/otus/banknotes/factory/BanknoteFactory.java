package ru.otus.banknotes.factory;

import ru.otus.banknotes.Banknotable;
import ru.otus.banknotes.NominalValue;
import ru.otus.banknotes.children.FiveHundredBanknote;
import ru.otus.banknotes.children.HundredBanknote;
import ru.otus.banknotes.children.ThousandBanknote;
import ru.otus.banknotes.children.TwoHundredBanknote;
import ru.otus.exceptions.NoSuchNominalValueExistsException;

public class BanknoteFactory {
    public Banknotable getBanknote(NominalValue nominalValueType) throws NoSuchNominalValueExistsException{
        switch (nominalValueType) {
            case HUNDRED:
                return new HundredBanknote();
            case TWO_HUNDRED:
                return new TwoHundredBanknote();
            case FIVE_HUNDRED:
                return new FiveHundredBanknote();
            case THOUSAND:
                return new ThousandBanknote();
            default:
                throw new NoSuchNominalValueExistsException();
        }
    }
}
