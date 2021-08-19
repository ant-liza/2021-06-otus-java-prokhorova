package ru.otus.banknotes.children;

import ru.otus.banknotes.Banknote;
import ru.otus.banknotes.NominalValue;

public class HundredBanknote extends Banknote {
    private final static NominalValue HUNDRED_NOMINAL_VALUE = NominalValue.HUNDRED;
    private final static int height = 150;
    private final static int width = 65;

    public HundredBanknote() {
        super(HUNDRED_NOMINAL_VALUE, HundredBanknote.height, HundredBanknote.width);
    }

}
