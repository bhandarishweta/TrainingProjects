package in.stackroute.joinmethod;

public class ThreadJoinTimedExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task("Timed thread"));
        thread.start();

        try {
            thread.join(1000);
            if (thread.isAlive()) {
                System.out.println("Thread still running. Interrupting the thread");
                thread.interrupt(); // interrupt does not stop or terminate the thread
            } else {
                System.out.println("Thread completed");
            }
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }
    }
}
