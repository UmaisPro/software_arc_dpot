package model;

import java.util.LinkedList;
import java.util.Queue;

public class QueueofCustomers {
    private Queue<Customer> customerQueue;

    public QueueofCustomers() {
        this.customerQueue = new LinkedList<>();
    }

    public void enqueue(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer dequeue() {
        return customerQueue.poll();
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }

    public Queue<Customer> getQueue() {
        return customerQueue;
    }
}
