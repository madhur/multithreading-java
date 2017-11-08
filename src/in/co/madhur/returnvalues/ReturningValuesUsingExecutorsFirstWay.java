package in.co.madhur.returnvalues;

import in.co.madhur.common.CalculationTaskA;
import in.co.madhur.common.LoopTaskA;
import in.co.madhur.common.NamedThreadsFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingExecutorsFirstWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        Future<Integer> result1 = executorService.submit(new CalculationTaskA(2, 3, 2000));
        Future<Integer> result2 = executorService.submit(new CalculationTaskA(3, 4, 1000));
        Future<Integer> result3 = executorService.submit(new CalculationTaskA(3, 4, 500));

        Future<?> result4 = executorService.submit(new LoopTaskA());
        Future<Double> result5 = executorService.submit(new LoopTaskA(), 999.888);

        executorService.shutdown();

        try {
            System.out.println("Result -1 =" + result1.get());
            System.out.println("Result -2 =" + result2.get());
            System.out.println("Result -3 =" + result3.get());
            System.out.println("Result -4 =" + result4.get());
            System.out.println("Result -5 =" + result5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
