package in.stackroute.executor;

public class ReadTask implements Runnable {

    private int taskId;

    public ReadTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Read Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println("Read Task ID : " + this.taskId + " interrupted by " + Thread.currentThread().getName());
        }
        System.out.println("Read Task ID : " + this.taskId + " completed by " + Thread.currentThread().getName());
    }
}
