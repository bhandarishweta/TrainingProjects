package in.stackroute.blockingop;

public class BlockingTaskThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();

        try {
            Thread.sleep(6000);

            if (thread.isAlive()) {
                System.out.println("Interrupting the Blocking Task");
                thread.interrupt();
            } else {
                System.out.println("Blocking Task Completed - no need to interrupt");
            }
        } catch (InterruptedException e) {
            System.err.println("Main Thread Interrupted");
            System.err.println(e.getMessage());
        }
    }
}
