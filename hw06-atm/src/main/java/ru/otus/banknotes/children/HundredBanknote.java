package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class HundredBanknote extends Banknote {
    private final static NominalValue HUNDRED_NOMINAL_VALUE = NominalValue.HUNDRED;

    public HundredBanknote() {
        super(HUNDRED_NOMINAL_VALUE, 150, 65);
    }

}
