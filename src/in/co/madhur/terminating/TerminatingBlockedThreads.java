package in.co.madhur.terminating;

import in.co.madhur.common.LoopTaskF;
import in.co.madhur.common.LoopTaskG;
import in.co.madhur.common.LoopTaskH;

import java.util.concurrent.TimeUnit;

public class TerminatingBlockedThreads {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        LoopTaskG task1 = new LoopTaskG();
        LoopTaskG task2 = new LoopTaskG();
        LoopTaskG task3 = new LoopTaskG();

        LoopTaskH task4 = new LoopTaskH();
        LoopTaskH task5 = new LoopTaskH();



        Thread t1 = new Thread(task1, "MyThread-1");
        Thread t2 = new Thread(task2, "MyThread-2");
        Thread t3 = new Thread(task3, "MyThread-3");

        Thread t4 = new Thread(task4, "MyThread-4");
        Thread t5 = new Thread(task5, "MyThread-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        TimeUnit.MILLISECONDS.sleep(3000);

        System.out.println("[" + currentThreadName + "] interrupting " + t1.getName() + "....");
        t1.interrupt();
        System.out.println("[" + currentThreadName + "] interrupting " + t2.getName() + "....");
        t2.interrupt();
        System.out.println("[" + currentThreadName + "] interrupting " + t3.getName() + "....");
        t3.interrupt();

        System.out.println("[" + currentThreadName + "] interrupting " + t4.getName() + "....");
        t4.interrupt();

        System.out.println("[" + currentThreadName + "] interrupting " + t5.getName() + "....");
        t5.interrupt();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");


    }
}
