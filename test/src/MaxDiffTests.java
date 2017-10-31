package src;

import in.co.madhur.MaxDiff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxDiffTests {

    @Test
    public void FirstTest() {

        int [] a = {2, 3, 10, 2, 4, 8 , 1};

        int result = MaxDiff.maxDifference(a);

        System.out.println(result);

        Assertions.assertEquals(result, 8);

    }

    @Test
    public void SecondTest() {

        int [] a = {7,9,5,6,3,2};

        int result = MaxDiff.maxDifference(a);

        System.out.println(result);

        Assertions.assertEquals(result, 2);

    }

    @Test
    public void ThirdTest() {

        int [] a = {10, 8, 7, 6, 5};

        int result = MaxDiff.maxDifference(a);

        System.out.println(result);

        Assertions.assertEquals(result, -1);

    }
}
