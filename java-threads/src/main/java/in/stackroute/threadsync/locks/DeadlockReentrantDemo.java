package in.stackroute.threadsync.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockReentrantDemo {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        boolean lock1Acquired = false;
        boolean lock2Acquired = false;
        try {
            lock1Acquired = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if (lock1Acquired) {
                System.out.println("Thread 1: Holding Lock 1");
                Thread.sleep(50);
                lock2Acquired = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
                if (lock2Acquired) {
                    System.out.println("Thread 1: Holding Lock 2");
                } else {
                    System.out.println("Thread 1: Lock 2 not acquired");
                }
            } else {
                System.out.println("Thread 1: Lock 1 not acquired");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock2Acquired) {
                System.out.println("Lock2 released by " + Thread.currentThread().getName());
                lock2.unlock();
            }
            if (lock1Acquired) {
                System.out.println("Lock1 released by " + Thread.currentThread().getName());
                lock1.unlock();
            }
        }
    }

    public void method2() {
        boolean lock1Acquired = false;
        boolean lock2Acquired = false;
        try {
            lock1Acquired = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if (lock1Acquired) {
                System.out.println("Thread 2: Holding Lock 1");
                Thread.sleep(50);
                lock2Acquired = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
                if (lock2Acquired) {
                    System.out.println("Thread 2: Holding Lock 2");
                } else {
                    System.out.println("Thread 2: Lock 2 not acquired");
                }
            } else {
                System.out.println("Thread 2: Lock 1 not acquired");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock2Acquired) {
                System.out.println("Lock2 released by Thread 2" );
                lock2.unlock();
            }
            if (lock1Acquired) {
                System.out.println("Lock1 released by Thread 2" );
                lock1.unlock();
            }
        }
    }

    public static void main(String[] args) {
        DeadlockReentrantDemo deadlockDemo = new DeadlockReentrantDemo();
        Thread thread1 = new Thread(deadlockDemo::method1);
        Thread thread2 = new Thread(deadlockDemo::method2);
        thread1.start();
        thread2.start();
    }
}
