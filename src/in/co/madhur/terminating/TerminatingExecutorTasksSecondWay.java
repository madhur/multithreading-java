package in.co.madhur.terminating;

import in.co.madhur.common.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminatingExecutorTasksSecondWay {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CalculationTaskC task1 = new CalculationTaskC();
        LoopTaskF task2 = new LoopTaskF();
        LoopTaskF task3 = new LoopTaskF();

        Future<Long> f1 = executorService.submit(task1);
        Future<?> f2 = executorService.submit(task2);
        Future<?> f3 = executorService.submit(task3);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(2000);

        System.out.println("[" + currentThreadName + "] Interrupting CalculationTaskC-1...");

        System.out.println("[" + currentThreadName + "] Cancelling f1 = " + f1.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting LoopTaskF-1...");
        System.out.println("[" + currentThreadName + "] Cancelling f2 = " + f2.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting LoopTaskF-2...");
        System.out.println("[" + currentThreadName + "] Cancelling f3 = " + f3.cancel(true));


        System.out.println("[" + currentThreadName + "] Main thread ends here...");


    }
}
