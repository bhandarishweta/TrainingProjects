package in.stackroute.joinmethod;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread thread1, thread2, thread3;
        thread1 = new Thread(new Task("Thread 1"));
        thread2 = new Thread(new Task("Thread 2"));
        thread3 = new Thread(new Task("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            thread1.join();
            System.out.println("Thread 1 completed. Waiting for Thread 2 and Thread 3 to complete.");

            thread2.join();
            System.out.println("Thread 2 completed. Waiting for Thread 3 to complete.");

            thread3.join();
            System.out.println("Thread 3 completed.");
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }
        System.out.println("Main thread completed");
    }
}


