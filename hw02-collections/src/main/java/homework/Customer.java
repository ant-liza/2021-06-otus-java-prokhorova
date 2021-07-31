package homework;


import java.util.Objects;

public class Customer {
    private final long id;
    private String name;
    private long scores;

    //todo: 1. в этом классе надо исправить ошибки

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }

    /**
     * Здесь оставила только айдишник, этого достаточно, чтобы сравнивать 2-х кастомеров
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id == customer.id;
    }

    /**
     * Здесь убрала поля scores и name, т.к. они "часто изменяемые"
     * Оставила только id, т.к. это поле уникальный идентификатор
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
