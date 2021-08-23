package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class TwoHundredBanknote extends Banknote {
    private final static NominalValue TWO_HUNDRED_NOMINAL_VALUE = NominalValue.TWO_HUNDRED;

    public TwoHundredBanknote() {
        super(TwoHundredBanknote.TWO_HUNDRED_NOMINAL_VALUE, 150, 65);
    }
}
