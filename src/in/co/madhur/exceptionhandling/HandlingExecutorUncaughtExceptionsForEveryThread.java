package in.co.madhur.exceptionhandling;

import in.co.madhur.common.ExceptionLeakingTask;
import in.co.madhur.common.ThreadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorUncaughtExceptionsForEveryThread {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());

        executorService.shutdown();
        executorService2.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
