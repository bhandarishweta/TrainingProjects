package in.stackroute.threadsync.vlt;

public class VolatileExample extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Running");
        }
    }

    public void shutdown() {
        running = false;
    }

    public static void main(String[] args) { // non-daemon thread
        VolatileExample thread = new VolatileExample();
        thread.start();
        thread.setDaemon(true); // cannot be called after start()
    }
}
