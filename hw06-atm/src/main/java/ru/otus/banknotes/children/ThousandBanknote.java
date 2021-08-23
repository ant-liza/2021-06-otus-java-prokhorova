package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class ThousandBanknote extends Banknote {
    private final static NominalValue THOUSAND_NOMINAL_VALUE = NominalValue.THOUSAND;

    public ThousandBanknote() {
        super(ThousandBanknote.THOUSAND_NOMINAL_VALUE, 157, 69);
    }

}
