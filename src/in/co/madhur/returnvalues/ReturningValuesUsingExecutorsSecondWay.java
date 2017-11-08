package in.co.madhur.returnvalues;

import in.co.madhur.common.*;

import java.util.concurrent.*;

public class ReturningValuesUsingExecutorsSecondWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CompletionService<TaskResult<String, Integer>> tasks = new ExecutorCompletionService<>(executorService);


        Future<TaskResult<String, Integer>> result1 = tasks.submit(new CalculationTaskB(2, 3, 2000));
        Future<TaskResult<String, Integer>> result2 = tasks.submit(new CalculationTaskB(3, 4, 1000));
        Future<TaskResult<String, Integer>> result3 = tasks.submit(new CalculationTaskB(4, 5, 500));

        //Future<?> result4 = executorService.submit(new LoopTaskA());
        Future<TaskResult<String, Integer>> result5 = tasks.submit(new LoopTaskA(), new TaskResult<>("LoopTaskA-1", 999));

        executorService.shutdown();

        for (int i=0; i< 4; ++i) {
            try {
                System.out.println("Result = " + tasks.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
