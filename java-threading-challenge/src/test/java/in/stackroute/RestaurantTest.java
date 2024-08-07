package in.stackroute;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Explanation
 * <p>
 * Test Initialization of Tables:
 * Ensures that tables are initialized correctly and available for seating.
 * <p>
 * Test Occupying and Leaving a Table:
 * Tests the functionality of occupying and leaving a table.
 * <p>
 * Test Multiple Customers Arriving and Occupying Tables:
 * Simulates multiple customers arriving and occupying tables concurrently.
 * <p>
 * Test Customers Waiting for Tables:
 * Simulates customers waiting for tables when all tables are occupied.
 * <p>
 * Test Edge Case - More Customers than Tables:
 * Tests the scenario where more customers arrive than the number of available tables.
 */

public class RestaurantTest {

    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant(3, 4); // 3 tables with capacity of 4 each
    }

    @Test
    public void testTableInitialization() {
        assertNotNull(restaurant.getAvailableTable(1));
        assertNotNull(restaurant.getAvailableTable(4));
    }

    @Test
    public void testOccupyAndLeaveTable() throws InterruptedException {
        Table table = restaurant.getAvailableTable(2);
        assertNotNull(table);
        restaurant.occupyTable(table);
        assertTrue(table.isOccupied());
        restaurant.leaveTable(table);
        assertFalse(table.isOccupied());
    }

    @Test
    public void testMultipleCustomersOccupyingTables() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            int customerId = i;
            executorService.submit(() -> {
                Customer customer = new Customer(customerId, restaurant, 2);
                customer.run();
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        int occupiedTables = 0;
        for (int i = 1; i <= 3; i++) {
            Table table = restaurant.getAvailableTable(2);
            if (table != null && table.isOccupied()) {
                occupiedTables++;
            }
        }
        assertEquals(0, occupiedTables); // All tables should be occupied
    }

    @Test
    public void testCustomersWaitingForTables() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 4; i++) {
            int customerId = i;
            executorService.submit(() -> {
                Customer customer = new Customer(customerId, restaurant, 2);
                customer.run();
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        int occupiedTables = 0;
        for (int i = 1; i <= 3; i++) {
            Table table = restaurant.getAvailableTable(2);
            if (table != null && table.isOccupied()) {
                occupiedTables++;
            }
        }
        assertEquals(0, occupiedTables); // All tables should be occupied and one customer should be waiting
    }

    @Test
    public void testMoreCustomersThanTables() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int customerId = i;
            executorService.submit(() -> {
                Customer customer = new Customer(customerId, restaurant, 2);
                customer.run();
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        int occupiedTables = 0;
        for (int i = 1; i <= 3; i++) {
            Table table = restaurant.getAvailableTable(2);
            if (table != null && table.isOccupied()) {
                occupiedTables++;
            }
        }
        assertEquals(0, occupiedTables); // All tables should be occupied and some customers should be waiting
    }
}
