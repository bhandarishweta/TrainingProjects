package in.stackroute.executor;

public class WriteTask implements Runnable {
    private int taskId;

    public WriteTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Write Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
        try {
            synchronized (this){
                wait(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Write Task ID : " + this.taskId + " interrupted by " + Thread.currentThread().getName());
        }
        System.out.println("Write Task ID : " + this.taskId + " completed by " + Thread.currentThread().getName());
    }
}
