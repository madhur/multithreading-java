package in.co.madhur.terminating;

import in.co.madhur.common.FactorialTaskA;
import in.co.madhur.common.LoopTaskE;
import in.co.madhur.common.LoopTaskF;
import in.co.madhur.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TerminatingExecutorTasksFirstWay {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        LoopTaskE task1 = new LoopTaskE();
        FactorialTaskA task2 = new FactorialTaskA(30, 1000);

        executorService.execute(task1);
        executorService.submit(task2);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3000);

        task1.cancel();
        task2.cancel();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");


    }
}
