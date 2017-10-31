package in.co.madhur;

  /*
     * Complete the function below.
 /*
     * Complete the function below.
     */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Discounts1 {


    public static void main(String[] args) throws IOException {


        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        int[] a = new int[a_size];
        for (int i = 0; i < a_size; i++) {
            int a_item;
            a_item = Integer.parseInt(in.nextLine().trim());
            a[i] = a_item;
        }

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = kDifference(a, k);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    static int kDifference(int[] a, int k) {
        //int pairs=0;
        Set<Pair> pairs = new HashSet<>();

        int n = a[0];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 1; j < a.length; ++j) {
                if (Math.abs(a[j] - a[i]) == k) {
                    System.out.println("Match is found" + a[i] + " " + a[j] + " " + k);

                    Pair pair = new Pair(BigInteger.valueOf(a[i]), BigInteger.valueOf(a[j]));
                    pairs.add(pair);
                }
            }

        }

        System.out.println(pairs.size());

        for (Pair pair : pairs) {
            System.out.println("Pair A: " + pair.a + " Pair B: " + pair.b);
        }

        return pairs.size();
    }

    static class Pair {

        public BigInteger a;
        public BigInteger b;

        public Pair(BigInteger a, BigInteger b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            BigInteger num = a.subtract(b);
            return Math.abs(num.intValue());
        }

        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair) obj;
            if ((this.a == o.a && this.b == o.b) || (this.a == o.b && this.b == o.a))
                return true;

            return false;
        }

    }

}

