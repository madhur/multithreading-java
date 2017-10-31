package in.co.madhur.Synchronized;

public class App {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.dowork();
    }

    private void dowork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i < 10000; i++) {

                    /* The increment is not an atomic operation. There are multiple steps involved.

                        The volatile will not solve it.
                     */
                    // count++;
                    increment();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i < 10000; i++) {

                    // count++;

                    increment();
                }

            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
}
