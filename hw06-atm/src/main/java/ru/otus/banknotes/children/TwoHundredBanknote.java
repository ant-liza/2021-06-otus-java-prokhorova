package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.Nominal;

public class TwoHundredBanknote extends Banknote {
    private final static Nominal TWO_HUNDRED_NOMINAL_VALUE = Nominal.TWO_HUNDRED;

    public TwoHundredBanknote() {
        super(TwoHundredBanknote.TWO_HUNDRED_NOMINAL_VALUE, 150, 65);
    }
}
