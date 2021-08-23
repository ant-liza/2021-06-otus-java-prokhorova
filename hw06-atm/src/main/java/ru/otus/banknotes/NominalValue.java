package ru.otus.banknotes;

import ru.otus.exceptions.NoSuchNominalValueExistsException;

public enum NominalValue {
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int value;

    NominalValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NominalValue getNominalValueByIntValue(int value) throws NoSuchNominalValueExistsException {
        for (NominalValue nv : values()) {
            if (nv.getValue() == value) {
                return nv;
            }
        }
        throw new NoSuchNominalValueExistsException(value);
    }
}
