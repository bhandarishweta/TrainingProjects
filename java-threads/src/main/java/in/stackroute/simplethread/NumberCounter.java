package in.stackroute.simplethread;

public class NumberCounter implements Runnable {

    private String threadName;
    private int start;
    private int end;

    public NumberCounter(String threadName, int start, int end) {
        this.threadName = threadName;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(threadName + " : " + i);
//            try {
//                Thread.sleep(500); // 1 second = 1000 milliseconds, state : Timed Waiting
//            } catch (InterruptedException e) {
//                System.err.println(threadName + " : " + e.getMessage());
//            }
        }
        System.out.println(threadName + " : Done!");
    }
}
/**
 * Thread States
 * New              : Thread is created but not started yet
 * Runnable         : Thread is running or ready to run
 * Blocked          : Thread is waiting for a monitor lock to enter a synchronized block/method
 * Waiting          : Thread is waiting for another thread to perform a particular action
 * Timed Waiting    : Thread is waiting for another thread to perform a particular action for a specified waiting time
 * Terminated       : Thread has completed its execution
 */