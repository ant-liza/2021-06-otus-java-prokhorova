package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.Nominal;

public class FiveHundredBanknote extends Banknote {
    private final static Nominal FIVE_HUNDRED_NOMINAL_VALUE = Nominal.FIVE_HUNDRED;

    public FiveHundredBanknote() {
        super(FiveHundredBanknote.FIVE_HUNDRED_NOMINAL_VALUE, 150, 65);
    }

}
