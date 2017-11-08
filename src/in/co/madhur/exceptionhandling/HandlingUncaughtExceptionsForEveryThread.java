package in.co.madhur.exceptionhandling;

import in.co.madhur.common.ExceptionLeakingTask;
import in.co.madhur.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsForEveryThread {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        try {
            new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
            new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
            new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
            new Thread(new ExceptionLeakingTask(), "MyThread-4").start();
        } catch (RuntimeException re) {
            System.out.println("[" + currentThreadName + "] Caught Exception: " + re);
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
