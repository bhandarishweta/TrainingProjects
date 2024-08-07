package in.stackroute.simplethread;

/**
 * main() is the default thread in Java
 */
public class Main {
    public static void main(String[] args) {
        NumberCounter numberCounter1, numberCounter2;
        Thread thread1, thread2;

        numberCounter1 = new NumberCounter("T1", 0, 10); // There are 11 numbers from 0 to 10
        numberCounter2 = new NumberCounter("T2", 1, 9);  // There are 9 numbers from 1 to 9

        thread1 = new Thread(numberCounter1); // State : New
        thread2 = new Thread(numberCounter2); // State : New

        System.out.println("Starting threads...");
        thread1.start(); // State : Runnable
        thread2.start(); // State : Runnable

        try {
            thread1.join(); // Main thread will wait until thread1 completes
            thread2.join(); // Main thread will wait until thread2 completes
        } catch (InterruptedException e) {
            System.err.println("Main thread : " + e.getMessage());
        }

        System.out.println("Main thread is done!");
    }
}
/**
 * School report generation
 * A school has multiple grades and ech has multiple divisions.
 * Each division has multiple students.
 * <p>
 * Annual Progress report
 * - Attendance percentage calculation  (1)
 * - Marks calculation for each subject (2)
 * - Project marks calculation          (3)
 * - Extra curricular marks calculation (4)
 * <p>
 * Final report is based on the above calculations.
 */
