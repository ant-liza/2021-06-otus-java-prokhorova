package homework;


import java.util.Stack;

public class CustomerReverseOrder {
    private Stack<Customer> stack = new Stack<>();

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"

    public void add(Customer customer) {
        stack.push(customer);
    }

    public Customer take() {
        return stack.pop();
    }
}
