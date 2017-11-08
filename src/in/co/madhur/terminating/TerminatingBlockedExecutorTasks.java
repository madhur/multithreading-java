package in.co.madhur.terminating;

import in.co.madhur.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminatingBlockedExecutorTasks {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskA task1 = new LoopTaskA();
        LoopTaskA task2 = new LoopTaskA();
        FactorialTaskB task3 = new FactorialTaskB(30, 500);

        Future<?> f1 = executorService.submit(task1);
        Future<?> f2 = executorService.submit(task2);
        Future<?> f3 = executorService.submit(task3);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(20000);

        System.out.println("[" + currentThreadName + "] Invoking cancel() on all the tasks...");
        f1.cancel(true);
        f2.cancel(true);
        f3.cancel(true);

        System.out.println("[" + currentThreadName + "] Main thread ends here...");


    }
}
