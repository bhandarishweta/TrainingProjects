package in.stackroute.threadsync.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantDearWriteDemo {

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static String data = "Initial data";

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final var x = i;
            Thread readerThread = new Thread(ReentrantDearWriteDemo::readData);
            Thread writerThread = new Thread(() -> writeData("New data " + x));
            writerThread.setName("writer-" + i);
            readerThread.setName("reader-" + i);
            writerThread.start();
            readerThread.start();
        }
    }

    private static void writeData(String str) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is writing data: " + str);
            data = str;
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " finished writing data: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            rwl.writeLock().unlock();
        }
    }

    private static void readData() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is reading data: " + data);
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " finished reading data: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            rwl.readLock().unlock();
        }
    }
}
