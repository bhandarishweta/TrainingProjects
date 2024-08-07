package in.stackroute.blockingop;

public class ResilientTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println("Resilient Task is running " + i + "th time");
            } catch (InterruptedException e) {
                System.err.println("Resilient Task is interrupted");
            }
        }
        System.out.println("Resilient Task is completed");
    }
}
