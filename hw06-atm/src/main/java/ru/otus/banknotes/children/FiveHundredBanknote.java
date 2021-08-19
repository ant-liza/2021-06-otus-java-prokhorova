package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class FiveHundredBanknote extends Banknote {
    private final static NominalValue FIVE_HUNDRED_NOMINAL_VALUE = NominalValue.FIVE_HUNDRED;
    private final static int height = 150;
    private final static int width = 65;

    public FiveHundredBanknote() {
        super(FiveHundredBanknote.FIVE_HUNDRED_NOMINAL_VALUE, FiveHundredBanknote.height, FiveHundredBanknote.width);
    }

}
