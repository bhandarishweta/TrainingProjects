package in.stackroute.daemons;

public class DaemonVsUserThread {
    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("User thread is running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println( Thread.currentThread().getName() + " is finished");
        });
        userThread.setName("User Thread");

        Thread daemonThread = new Thread(() -> {
            try {
                while(true) {
                    System.out.println("Daemon thread is running");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        daemonThread.setName("Daemon Thread");
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        userThread.join();

        System.out.println("Main thread is finished");
    }
}
