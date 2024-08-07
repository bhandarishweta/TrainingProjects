package in.stackroute.joinmethod;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        try {
            System.out.println(name + " sleeping");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println(name + " interrupted");
            System.err.println(e.getMessage());
        }
    }
}
