package simplejavaapps.FindMissing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMissingTest {

    @Test
    void findMissingNumber() {

        Assertions.assertAll(this::test1,this::test2,this::test3,this::test4,this::test5,this::test6,this::test7,this::test8,this::test9);


    }

    @Test
    void test1()
    {
        // from zero to n, one number is missing, increasing
        double[] tableWithMissingNumber = {0,1,2,3,4,5,6,8};
        Assertions.assertEquals(7,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {0,2,4,6,8,10,14};
        Assertions.assertEquals(12,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test2()
    {
        // from n1 to n2, one number is missing, increasing
        double[] tableWithMissingNumber = {1,2,3,4,5,6,8};
        Assertions.assertEquals(7,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {2,4,6,8,10,14};
        Assertions.assertEquals(12,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test3()
    {
        // from zero to n, one number is missing, decreasing
        double[] tableWithMissingNumber = {8,6,5,4,3,2,1,0};
        Assertions.assertEquals(7,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {14,10,8,6,4,2,0};
        Assertions.assertEquals(12,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test4()
    {
        // from n1 to n2, one number is missing, decreasing
        double[] tableWithMissingNumber = {8,6,5,4,3,2,1};
        Assertions.assertEquals(7,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {14,10,8,6,4,2};
        Assertions.assertEquals(12,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test5()
    {
        // from -n1 to n2, one positive number is missing, increasing
        double[] tableWithMissingNumber = {-3,-2,-1,0,1,2,3,5};
        Assertions.assertEquals(4,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {-6,-4,-2,0,2,6,8};
        Assertions.assertEquals(4,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test6()
    {
        // from -n1 to n2, one negative number is missing, increasing
        double[] tableWithMissingNumber = {-3,-1,0,1,2,3,4,5};
        Assertions.assertEquals(-2,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {-6,-2,0,2,4,6,8};
        Assertions.assertEquals(-4,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test7()
    {
        // from -n1 to n2, one positive number is missing, decreasing
        double[] tableWithMissingNumber = {5,3,2,1,0,-1,-2,-3};
        Assertions.assertEquals(4,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {8,6,2,0,-2,-4};
        Assertions.assertEquals(4,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test8()
    {
        // from -n1 to n2, one negative number is missing, decreasing
        double[] tableWithMissingNumber = {5,4,3,2,1,0,-1,-3};
        Assertions.assertEquals(-2,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {8,6,4,2,0,-2,-6};
        Assertions.assertEquals(-4,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

    @Test
    void test9()
    {
        // from -n1 to n2, zero is missing, increasing
        double[] tableWithMissingNumber = {-3,-2,-1,1,2,3,4,5};
        Assertions.assertEquals(0,FindMissing.findMissingNumber(tableWithMissingNumber));

        double[] tableWithMissingNumber2 = {-6,-4,-2,2,4,6,8};
        Assertions.assertEquals(0,FindMissing.findMissingNumber(tableWithMissingNumber2));

    }

}