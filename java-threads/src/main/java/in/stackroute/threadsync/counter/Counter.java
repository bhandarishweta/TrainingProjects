package in.stackroute.threadsync.counter;

public class Counter {

    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int value() {
        return counter;
    }
}
