package in.co.madhur.executorservice;

import in.co.madhur.common.LoopTaskC;
import in.co.madhur.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCachedThreadPoolPart2 {

    public static void main(String[] args) throws InterruptedException {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        TimeUnit.SECONDS.sleep(15);

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());


        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
