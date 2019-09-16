package simplejavaapps;


import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

    NWW.runTest();
    //Counter.CountFromZeroTo(10);
    //Counter.CountFromNumberToZero(10);
    //Counter.CountForwardXToY(3,10);
    //Counter.CountBackwardYToX(3,10);

/*
    ArrayFactory arrayFactory = new ArrayFactory(5);
    int[] a1 = arrayFactory.oneDimension();
    int[][] a2 = arrayFactory.twoDimension();
    int[][] identityMatrix = arrayFactory.identityMatrix();

*/

    //ReverseOrderCounter.displayInReverseOrder(56789);

    //Anagram.anagram("very long text");

    //NumberAsBinary.displayAsBinary(5);

        //Palindrome.isPalindrome("oddo");

        //TableOfNumbers.displayNumbersFromTable(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        int[] table = RandomTableFactory.getRandomTable(1600,0,8);
        int[] table2 = new int[]{5,2,3,1,6};
        SortTable.sortTableBubbleIncreasing(Arrays.copyOf(table,table.length));
        SortTable.sortTableBubbleIncreasingSkipSorted(Arrays.copyOf(table,table.length));
        SortTable.sortTableBubbleDecreasing(Arrays.copyOf(table,table.length));
        SortTable.sortTableBubbleDecreasingSkipSorted(Arrays.copyOf(table,table.length));


        for(int i = 0;i<1;i++) {


            long startTime = System.nanoTime();
            int[] result = SortTable.sortTableQuickRecursiveIncreasing(Arrays.copyOf(table,table.length),0,table.length-1);

            System.out.println("[QUICKSORT/INCREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(result));
        }


        for(int i = 0;i<1;i++) {


            long startTime = System.nanoTime();
            int[] result = SortTable.sortTableQuickRecursiveDecreasing(Arrays.copyOf(table,table.length),0,table.length-1);

            System.out.println("[QUICKSORT/DECREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(result));
        }



    }


    private void getSortingTime(Method method)
    {

    }
}