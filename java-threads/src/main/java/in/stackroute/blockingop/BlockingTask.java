package in.stackroute.blockingop;

public class BlockingTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Blocking Task Started");
        try {
            Thread.sleep(5000);
            System.out.println("Out from sleep"); // not executed
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Blocking Task Completed");
    }
}
