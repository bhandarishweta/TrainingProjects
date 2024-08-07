package in.stackroute.threadsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceSharedDataExample {

    private static int counter = 0;
    private static final int TASK_COUNT = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < TASK_COUNT; i++) {
            executorService.execute(ExecutorServiceSharedDataExample::incrementCounter);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Final counter value: " + counter);
    }

    private synchronized static void incrementCounter() {
        try {
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter incremented by: " + Thread.currentThread().getName() + " to: " + counter);
    }
}
