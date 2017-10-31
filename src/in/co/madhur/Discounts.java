package in.co.madhur;

import java.util.ArrayList;

public class Discounts {

    /*
    * Complete the function below.
    */
    static long calculateAmount(int[] prices) {

        ArrayList<Integer> costs = new ArrayList<>();
        Long sum = 0L;

        for(int i=0; i<prices.length; ++i) {

            if(i==0) {
                System.out.println("Inserting cost: " + prices[i]);
                costs.add(prices[i]);
                sum = sum  + prices[i];
            } else if(i==1) {
                int cost = prices[i] - prices[0];
                if (cost < 0) {
                    cost = 0;
                }
                System.out.println("Inserting cost: " + (prices[i] - prices[0]));
                costs.add(cost);
                sum = sum + cost;
            } else {
                int price = prices[i];
                int min = findMin(prices, i);
                if (price < min) {
                    System.out.println("Inserting cost: 0");
                    // costs.add(0);
                } else {
                    int cost = price - min;
                    System.out.println("Inserting cost: " + cost);
                    costs.add(cost);
                    sum = sum + cost;
                }
            }
        }


        return sum;
    }

    private static int findMin(int[] prices, int index) {


        int min = prices[0];
        for(int i = 0; i< index; ++i) {
            System.out.print("checking min: " + prices[i]);
            if(min > prices[i]) {
                min = prices[i];
            }
        }

        System.out.println("Got min: " + min);
        return min;
    }

}
