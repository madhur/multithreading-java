package in.co.madhur.executorservice;

import in.co.madhur.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

    public static void main(String[] args) {

        System.out.println("Main thread starts here...");

        ExecutorService execService = Executors.newFixedThreadPool(6);

        execService.execute(new LoopTaskA());
        execService.execute(new LoopTaskA());
        execService.execute(new LoopTaskA());

        execService.execute(new LoopTaskA());
        execService.execute(new LoopTaskA());
        execService.execute(new LoopTaskA());


        execService.shutdown();



        System.out.println("Main thread ends here...");
    }
}
