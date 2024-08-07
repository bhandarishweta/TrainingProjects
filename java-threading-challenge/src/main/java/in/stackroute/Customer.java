package in.stackroute;

import java.util.Optional;

public class Customer implements Runnable {

    private int customerId;
    private Restaurant restaurant;
    private int groupSize;

    public Customer(int customerId, Restaurant restaurant, int groupSize) {
        this.customerId = customerId;
        this.restaurant = restaurant;
        this.groupSize = groupSize;
    }

    @Override
    public void run() {

        try {
            System.out.println("Customer " + customerId + " with group size " + groupSize + " arrived at the restaurant.");
            Table table = restaurant.getAvailableTable(groupSize);
            if (table!=null) {

                restaurant.occupyTable(table);
                Thread.sleep((long) (Math.random() * 10000)); // Simulate dining time
                restaurant.leaveTable(table);
                System.out.println("Customer " + customerId + " left table " + table.getTableId());
            } else {
                System.out.println("Customer " + customerId + " found no available table and left the restaurant.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
}
