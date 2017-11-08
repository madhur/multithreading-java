package in.co.madhur.daemon;

import in.co.madhur.common.LoopTaskD;

public class DaemonThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread t1 = new Thread(new LoopTaskD(500), "Thread-1");
        Thread t2 = new Thread(new LoopTaskD(1000), "Thread-2");

        t1.setDaemon(true);
        //t2.setDaemon(true);
        t1.start();
        t2.start();


        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
