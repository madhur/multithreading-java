package in.co.madhur.demo2;


class Runner implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; ++i) {
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());

        t1.start();
        t2.start();

    }

    static class Pair{

        public Integer a;
        public Integer b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return a + b;
        }


        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair) obj;
            if((this.a == o.a && this.b==o.b) || (this.a == o.b && this.b == o.a))
                return true;

            return false;
        }

        public boolean equals(Pair o) {
            if((this.a == o.a && this.b==o.b) || (this.a == o.b && this.b == o.a))
                return true;

            return false;
        }
    }

}
