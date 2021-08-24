package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.Nominal;

public class ThousandBanknote extends Banknote {
    private final static Nominal THOUSAND_NOMINAL_VALUE = Nominal.THOUSAND;

    public ThousandBanknote() {
        super(ThousandBanknote.THOUSAND_NOMINAL_VALUE, 157, 69);
    }

}
