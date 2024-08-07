package in.stackroute.threadsync.locks;

public class DeadlockDemo {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Lock1 acquired by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted " + e.getMessage());
            }
            synchronized (lock2) {
                System.out.println("Lock2 acquired by " + Thread.currentThread().getName());
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Lock2 acquired by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted " + e.getMessage());
            }
            synchronized (lock1) {
                System.out.println("Lock1 acquired by " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        Thread thread1 = new Thread(deadlockDemo::method1);
        Thread thread2 = new Thread(deadlockDemo::method2);
        thread1.start();
        thread2.start();
    }
}
