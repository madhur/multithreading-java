package in.co.madhur.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskH implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private boolean sleepInterrupted = false;

    @Override
    public void run() {

        boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();

        String threadType = isRunningInDaemonThread ? "DAEMON" : "USER";

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("###  [" + currentThreadName + ", " + threadType + "] <" + taskId + "> STARTING ###");

        for(int i=1;;i++) {
            System.out.println("[" + currentThreadName + ", " + threadType + "] <" + taskId + ">TICK TICK" + i);

            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 3000));
            } catch (InterruptedException e) {
                System.out.println("*** [" + currentThreadName + "] <" + taskId + "> Sleep interrupted." + "SETTING THE FLAG ...");
                sleepInterrupted = true;
            }

            doSomeMoreWork(currentThreadName);

            if(sleepInterrupted || Thread.interrupted()) {
                System.out.println("**** [" + currentThreadName + "] <" + taskId + "> INTERRUPTED. Cancelling...");
                break;
            }

        }

        System.out.println("*** [" + currentThreadName + ", " + threadType + "] <" + taskId + "> DONE ***");

    }

    private void doSomeMoreWork(String currentThreadName) {
        System.out.println("*** [" + currentThreadName + "] <" + taskId + "> DOING SOME MORE WORK ...");
    }

    public LoopTaskH() {

        this.instanceNumber = ++count;
        this.taskId = "LoopTaskH" + instanceNumber;
    }
}
