package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class ThousandBanknote extends Banknote {
    private final static NominalValue THOUSAND_NOMINAL_VALUE = NominalValue.THOUSAND;
    private final static int height = 157;
    private final static int width = 69;

    public ThousandBanknote() {
        super(ThousandBanknote.THOUSAND_NOMINAL_VALUE, ThousandBanknote.height, ThousandBanknote.width);
    }

}
