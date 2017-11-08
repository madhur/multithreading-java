package in.co.madhur.joining;

import in.co.madhur.common.ExceptionLeakingTask;
import in.co.madhur.common.LoopTaskI;
import in.co.madhur.common.NamedThreadsFactory;
import in.co.madhur.common.ThreadFactoryWithExceptionHandler;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoiningExecutorThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CountDownLatch doneSignal = new CountDownLatch(2);

        executorService.execute(new LoopTaskI(null));
        executorService.execute(new LoopTaskI(doneSignal));
        executorService.execute(new LoopTaskI(doneSignal));
        executorService.execute(new LoopTaskI(null));

        executorService.shutdown();

        try {
            doneSignal.await();
            System.out.println("[" + currentThreadName + "] GOT THE SIGNAL TO CONTINUE...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
