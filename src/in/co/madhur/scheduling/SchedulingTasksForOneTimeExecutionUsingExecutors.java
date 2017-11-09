package in.co.madhur.scheduling;

import in.co.madhur.common.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulingTasksForOneTimeExecutionUsingExecutors {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

    public static void main(String[] args) throws Exception {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

       // ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadsFactory());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());

        System.out.println("[" + currentThreadName + "] Current time: " + dateFormatter.format(new Date()));

        ScheduledFuture<?> scheduledFuture1 = executorService.schedule(new ScheduledTaskB(0), 4, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture2 = executorService.schedule(new CalculationTaskD(2, 3, 0), 6, TimeUnit.SECONDS);

        executorService.schedule(new ScheduledTaskB(0), 8, TimeUnit.SECONDS);

        ScheduledFuture<Integer> scheduledFuture4 = executorService.schedule(new CalculationTaskD(3, 4, 0), 10, TimeUnit.SECONDS);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] retreiving the results now...");

        System.out.println("[" + currentThreadName + "] Task-1 Result - " + scheduledFuture1.get());
        System.out.println("[" + currentThreadName + "] Task-2 Result - " + scheduledFuture2.get());
        System.out.println("[" + currentThreadName + "] Task-4 Result - " + scheduledFuture4.get());

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
