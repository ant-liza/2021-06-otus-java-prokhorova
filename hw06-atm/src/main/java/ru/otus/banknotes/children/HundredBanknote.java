package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.Nominal;

public class HundredBanknote extends Banknote {
    private final static Nominal HUNDRED_NOMINAL_VALUE = Nominal.HUNDRED;

    public HundredBanknote() {
        super(HUNDRED_NOMINAL_VALUE, 150, 65);
    }

}
