package in.co.madhur.callable;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Doesn't return a value
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//
//                Random random = new Random();
//                int duration = random.nextInt(4000);
//
//                System.out.println("Starting...");
//
//                try {
//                    Thread.sleep(duration);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Finished.");
//            }
//        });
//

        //
        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {

                Random random = new Random();
                int duration = random.nextInt(4000);

                if (duration > 2000) {
                    throw new IOException("Sleeping for too long.");
                }

                System.out.println("Starting...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");

                return duration;
            }
        });

        executor.shutdown();

        //executor.awaitTermination()

        try {
            System.out.println("Resut is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
