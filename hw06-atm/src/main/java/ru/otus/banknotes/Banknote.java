package ru.otus.banknotes;

/**
 * Абстрактный класс для банкнот
 * У каждой банкноты есть свой номинал и физические параметры:
 */
public abstract class Banknote implements Banknotable {
    private final Nominal nominal;
    private final int height;
    private final int width;

    public Banknote(Nominal nominal, int height, int width) {
        this.nominal = nominal;
        this.height = height;
        this.width = width;
    }

    @Override
    public Nominal getNominalValue() {
        return nominal;
    }

    @Override
    public String toString() {
        return "\nBanknote{" +
                "nominalValue=" + nominal + "(" + nominal.getValue() + ")" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
