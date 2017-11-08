package in.co.madhur.exceptionhandling;

import in.co.madhur.common.ExceptionLeakingTask;
import in.co.madhur.common.ThreadExceptionHandler;
import in.co.madhur.common.ThreadFactoryWithExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsDifferentlyPerThread {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());

        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        executorService.shutdown();



        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
