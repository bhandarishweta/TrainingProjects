package in.stackroute.blockingop;

public class ResilientTaskThread {

    public static void main(String[] args) {
        ResilientTask task = new ResilientTask();
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(50);
            thread.interrupt();
            if (thread.isInterrupted()) {
                System.out.println("Thread is interrupted");
            }
            if (thread.isAlive()) {
                System.out.println("Thread is still alive");
            }
        } catch (InterruptedException e) {
            System.err.println("Main thread is interrupted");
        }
    }
}
