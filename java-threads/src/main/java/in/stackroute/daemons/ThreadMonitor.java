package in.stackroute.daemons;

import java.util.Arrays;

public class ThreadMonitor {
    public static void main(String[] args) {
        createSampleThread();
        ThreadGroup rootGroup = getRootThreadGroup();
        Thread[] allThreads = getAllThreads(rootGroup);
        for (Thread thread : allThreads) {
            System.out.println(thread.getName() + " (Daemon: " + thread.isDaemon() + ")");
        }
    }

    private static void createSampleThread() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "User-Thread-1").start();
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Daemon-Thread-1");
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    private static ThreadGroup getRootThreadGroup() {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (rootGroup.getParent() != null) {
            rootGroup = rootGroup.getParent();
        }
        return rootGroup;
    }

    private static Thread[] getAllThreads(ThreadGroup group) {
        int estimatedCount = group.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedCount];
        int actualCount = group.enumerate(slackList, true);
        Thread[] result = new Thread[actualCount];
        System.arraycopy(slackList, 0, result, 0, actualCount);
        return result;
    }
}
