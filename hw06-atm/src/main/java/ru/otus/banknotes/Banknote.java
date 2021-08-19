package ru.otus.banknotes;

/**
 * Абстрактный класс для банкнот
 * У каждой банкноты есть свой номинал и физические параметры:
 */
public abstract class Banknote implements Banknotable {
    private final NominalValue nominalValue;
    private final int height;
    private final int width;

    public Banknote(NominalValue nominalValue, int height, int width) {
        this.nominalValue = nominalValue;
        this.height = height;
        this.width = width;
    }

    @Override
    public NominalValue getNominalValue() {
        return nominalValue;
    }

    @Override
    public String toString() {
        return "\nBanknote{" +
                "nominalValue=" + nominalValue + "(" + nominalValue.getValue() + ")" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
