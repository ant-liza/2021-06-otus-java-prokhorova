package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class FiveHundredBanknote extends Banknote {
    private final static NominalValue FIVE_HUNDRED_NOMINAL_VALUE = NominalValue.FIVE_HUNDRED;

    public FiveHundredBanknote() {
        super(FiveHundredBanknote.FIVE_HUNDRED_NOMINAL_VALUE, 150, 65);
    }

}
