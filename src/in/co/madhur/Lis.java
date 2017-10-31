package in.co.madhur;

import java.util.HashMap;

public class Lis {


/*
 * Complete the function below.
 */

    static int findLIS(int[] s) {
        HashMap<Integer, NumPair> lengths = new HashMap<Integer, NumPair>();

        for(int i=0; i <s.length; ++i) {

            lengths.put(i, new NumPair(1, s[i]) );

        }

        for(Integer key: lengths.keySet()) {

            Integer maxvalue = lengths.get(key).maxvalue;
            Integer chainlength = lengths.get(key).chainlength;
            // System.out.println("key: " + key + " maxvalue " + maxvalue + " chainlength " + chainlength);
            for(int i=0; i <s.length; ++i) {
                if( s[i] > maxvalue && i > key) {

                    // int num = lengths.get(key);
                    //System.out.println("s[i]= " + s[i] + " > maxvalue " + maxvalue + " key  " + key + " chainlength " + chainlength);
                    maxvalue = s[i];
                    lengths.put(key,new NumPair(++chainlength, maxvalue));

                }

            }
        }

        int big=0;
        for(NumPair val: lengths.values()) {
            if (val.chainlength > big) {
                big = val.chainlength;
            }
        }

        return big;

    }


    static class NumPair {

        Integer chainlength;
        Integer maxvalue;

        public NumPair(Integer chainlength, Integer maxvalue) {
            this.chainlength = chainlength;
            this.maxvalue = maxvalue;
        }
    }


}
