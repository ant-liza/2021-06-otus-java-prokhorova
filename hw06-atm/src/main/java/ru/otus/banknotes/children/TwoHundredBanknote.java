package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class TwoHundredBanknote extends Banknote {
    private final static NominalValue TWO_HUNDRED_NOMINAL_VALUE = NominalValue.TWO_HUNDRED;
    private final static int height = 150;
    private final static int width = 65;

    public TwoHundredBanknote() {
        super(TwoHundredBanknote.TWO_HUNDRED_NOMINAL_VALUE, TwoHundredBanknote.height, TwoHundredBanknote.width);
    }
}
