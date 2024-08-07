package in.stackroute.threadsync.counter;

public class CounterMain {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread incrementThread = new IncrementThread(counter);
        Thread decrementThread = new DecrementThread(counter);

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.value());
    }
}
// Expected output?
// 0, No Output, 999, -999, Possible data inconsistency
// 1, -1