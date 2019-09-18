package simplejavaapps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.*;

class RandomTableFactoryTest {

    private int tableSize = 100; //size of test table (affects test accuracy)


    @org.junit.jupiter.api.RepeatedTest(1000)
    void getRandomTableTestAccuracy(RepetitionInfo repetitionInfo) {

    getRandomTableNegativeToPositive();
    getRandomTableBothNegative();
    getRandomTableBothPositive();
    getRandomTableNegativeToZero();
    getRandomTableZeroToPositive();


    }

    @org.junit.jupiter.api.Test
    void getRandomTableBothNegative() {

        int min = -4;
        int max = -2;

        System.out.println("MIN: "+min+" MAX: "+max);
        int[] table = RandomTableFactory.getRandomTable(tableSize,min,max);
        SortTable.sortTableBubbleIncreasingSkipSorted(table);
        Assertions.assertTrue(min==table[0] & max==table[table.length-1]);


    }

    @org.junit.jupiter.api.Test
    void getRandomTableNegativeToZero() {

        int min = -2;
        int max = 0;

        System.out.println("MIN: "+min+" MAX: "+max);
        int[] table = RandomTableFactory.getRandomTable(tableSize,min,max);
        SortTable.sortTableBubbleIncreasingSkipSorted(table);
        Assertions.assertTrue(min==table[0] & max==table[table.length-1]);


    }

    @org.junit.jupiter.api.Test
    void getRandomTableZeroToPositive() {

        int min = 0;
        int max = 2;

        System.out.println("MIN: "+min+" MAX: "+max);
        int[] table = RandomTableFactory.getRandomTable(tableSize,min,max);
        SortTable.sortTableBubbleIncreasingSkipSorted(table);
        Assertions.assertTrue(min==table[0] & max==table[table.length-1]);


    }

    @org.junit.jupiter.api.Test
    void getRandomTableBothPositive() {

        int min = 2;
        int max = 4;

        System.out.println("MIN: "+min+" MAX: "+max);
        int[] table = RandomTableFactory.getRandomTable(tableSize,min,max);
        SortTable.sortTableBubbleIncreasingSkipSorted(table);
        Assertions.assertTrue(min==table[0] & max==table[table.length-1]);


    }

    @org.junit.jupiter.api.Test
    void getRandomTableNegativeToPositive() {

        int min = -2;
        int max = 2;

        System.out.println("MIN: "+min+" MAX: "+max);
        int[] table = RandomTableFactory.getRandomTable(tableSize, min, max);
        SortTable.sortTableBubbleIncreasingSkipSorted(table);
        Assertions.assertTrue(min == table[0] & max == table[table.length - 1]);


    }




}