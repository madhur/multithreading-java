package in.co.madhur.diningphilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = null;

        Philosopher[] philosophers = new Philosopher[Constants.NUMBER_PHILOSOPHERS];
        Chopstick[] chopsticks = new Chopstick[Constants.NUMBER_CHOPSTICKS];

        for (int i=0;i < Constants.NUMBER_CHOPSTICKS; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        try {

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_PHILOSOPHERS);

            for (int i=0; i<Constants.NUMBER_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1) % Constants.NUMBER_CHOPSTICKS]);

                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for(Philosopher p : philosophers) {
                p.setFull(true);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(executorService != null) {
                executorService.shutdown();


                while (!executorService.isTerminated()) {
                    Thread.sleep(1000);
                }
            }

            for(Philosopher p : philosophers) {
                System.out.println(p + " eats " + p.getEatingCounter());
            }
        }

    }
}
