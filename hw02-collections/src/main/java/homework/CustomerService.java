package homework;


import java.util.*;


public class CustomerService {
    Comparator comparator = Comparator.comparingLong(o -> ((Customer) o).getScores());
    NavigableMap<Customer, String> map = new TreeMap<>(comparator);

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        Customer existsCustomer = map.firstEntry().getKey();
        Customer customerForReturn = new Customer(existsCustomer.getId(), existsCustomer.getName(), existsCustomer.getScores());
        return new AbstractMap.SimpleEntry<>(customerForReturn, map.firstEntry().getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        if (map.higherEntry(customer) == null) return null;
        Customer existsCustomer = map.higherEntry(customer).getKey();
        Customer customerForReturn = new Customer(existsCustomer.getId(), existsCustomer.getName(), existsCustomer.getScores());
        return new AbstractMap.SimpleEntry<>(customerForReturn, map.higherEntry(customer).getValue());
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
