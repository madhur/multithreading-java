package in.co.madhur.daemon;

import in.co.madhur.common.DaemonThreadsFactory;
import in.co.madhur.common.LoopTaskD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadsUsingExecutors {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadsFactory());

        executorService.execute(new LoopTaskD(100));
        executorService.execute(new LoopTaskD(200));
        executorService.execute(new LoopTaskD(100));
        executorService.execute(new LoopTaskD(100));

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
