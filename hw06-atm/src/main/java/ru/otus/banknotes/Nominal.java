package ru.otus.banknotes;

import ru.otus.exceptions.NoSuchNominalValueExistsException;

import java.util.Arrays;
import java.util.Comparator;

public enum Nominal {
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int value;

    Nominal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Nominal getNominalValueByIntValue(int value) throws NoSuchNominalValueExistsException {
        for (Nominal nv : values()) {
            if (nv.getValue() == value) {
                return nv;
            }
        }
        throw new NoSuchNominalValueExistsException(value);
    }

    public static Nominal getMinNominal() {
        int min = Integer.MAX_VALUE;
        for (Nominal nv : values()) {
            if (nv.getValue() < min) {
                min = nv.getValue();
            }
        }
        return Nominal.getNominalValueByIntValue(min);
    }

    public static Nominal getMaxNominal() {
        int max = Integer.MIN_VALUE;
        for (Nominal nv : values()) {
            if (nv.getValue() > max) {
                max = nv.getValue();
            }
        }
        return Nominal.getNominalValueByIntValue(max);
    }


}
