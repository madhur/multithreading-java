package in.co.madhur.executorservice;

import in.co.madhur.common.LoopTaskC;
import in.co.madhur.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NamingExecutorThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        execService.execute(new LoopTaskC());
        execService.execute(new LoopTaskC());
        execService.execute(new LoopTaskC());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
