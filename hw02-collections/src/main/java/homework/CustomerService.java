package homework;


import java.util.*;


public class CustomerService {
    private final Comparator comparator = Comparator.comparingLong(o -> ((Customer) o).getScores());
    private final NavigableMap<Customer, String> map = new TreeMap<>(comparator);

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        Customer existsCustomer = map.firstEntry().getKey();
        Customer customerForReturn = new Customer(existsCustomer.getId(), existsCustomer.getName(), existsCustomer.getScores());
        return new AbstractMap.SimpleEntry<>(customerForReturn, map.firstEntry().getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> existsCustomerEntry = map.higherEntry(customer);
        if (existsCustomerEntry == null) {
            return null;
        }
        Customer existsCustomer = existsCustomerEntry.getKey();
        Customer customerForReturn = new Customer(existsCustomer.getId(), existsCustomer.getName(), existsCustomer.getScores());
        return new AbstractMap.SimpleEntry<>(customerForReturn, existsCustomerEntry.getValue());
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
