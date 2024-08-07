package in.stackroute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RestaurantSimulation {
    public static void main(String[] args) {
        int numberOfTables = 5;
        int capacityPerTable = 4;
        Restaurant restaurant = new Restaurant(numberOfTables, capacityPerTable);

        ScheduledExecutorService customerArrivalScheduler = Executors.newScheduledThreadPool(1);
        ExecutorService customerExecutor = Executors.newCachedThreadPool();

        customerArrivalScheduler.scheduleAtFixedRate(() -> {
            int groupSize = (int) (Math.random() * 4) + 1; // Random group size between 1 and 4
            int customerId =(int) (Math.random() * 10) + 1;
            Customer customer = new Customer(customerId, restaurant, groupSize);
            customerExecutor.execute(customer);
        }, 0, (long) (Math.random() * 5 + 1), TimeUnit.SECONDS); // Customers arrive every 1 to 5 seconds

        // Run the simulation for 1 minute
        customerArrivalScheduler.schedule(() -> {
            customerArrivalScheduler.shutdown();
            customerExecutor.shutdown();
        }, 1, TimeUnit.MINUTES);
    }
}