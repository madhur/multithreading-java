package in.co.madhur.terminating;

import in.co.madhur.common.LoopTaskE;
import in.co.madhur.common.LoopTaskF;

import java.util.concurrent.TimeUnit;

public class TerminatingThreadsSecondWay {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        LoopTaskF task1 = new LoopTaskF();
        LoopTaskF task2 = new LoopTaskF();
        LoopTaskF task3 = new LoopTaskF();

        Thread t1 = new Thread(task1, "MyThread-1");
        Thread t2 = new Thread(task2, "MyThread-2");
        Thread t3 = new Thread(task3, "MyThread-3");

        t1.start();
        t2.start();
        t3.start();

        TimeUnit.MILLISECONDS.sleep(5000);


        TimeUnit.MILLISECONDS.sleep(3000);

        System.out.println("[" + currentThreadName + "] interrupting " + t1.getName() + "....");
        t1.interrupt();
        System.out.println("[" + currentThreadName + "] interrupting " + t2.getName() + "....");
        t2.interrupt();
        System.out.println("[" + currentThreadName + "] interrupting " + t3.getName() + "....");
        t3.interrupt();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");


    }
}
