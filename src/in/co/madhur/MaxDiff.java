package in.co.madhur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class MaxDiff {

    /*
     * Complete the function below.
     */
    public static int maxDifference(int[] a) {
        HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
        Integer LargestDiff = -1;

        for(int i =0; i < a.length; ++i) {
            for(int j=1; j < a.length; ++j) {

                if(i < j && a[i] < a[j]) {

                    Integer diff = a[j] - a[i];
                    System.out.println("Max diff: " + diff + " , a[j]: " + a[j] + " a[i]: " + a[i]);
                    if(diff > LargestDiff) {
                        LargestDiff = diff;
                    }
                }
            }
        }

        return LargestDiff;

    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        int[] a = new int[a_size];
        for(int i = 0; i < a_size; i++) {
            int a_item;
            a_item = Integer.parseInt(in.nextLine().trim());
            a[i] = a_item;
        }

        res = maxDifference(a);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
