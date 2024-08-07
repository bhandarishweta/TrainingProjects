package in.stackroute.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) {
//        ExecutorService writeServicePool = Executors.newFixedThreadPool(2);
        ExecutorService readServicePool = Executors.newFixedThreadPool(1);


//        for (int i = 0; i < 3; i++) {
//            Runnable task = new WriteTask(i);
//            writeServicePool.execute(task);
//        }
        for (int i = 0; i < 5; i++) {
            Runnable task = new ReadTask(i);
            readServicePool.execute(task);
        }

//        writeServicePool.shutdown();
        readServicePool.shutdown();
    }
}
