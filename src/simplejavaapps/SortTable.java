package simplejavaapps;

import java.util.Arrays;

public class SortTable {

    /*
    Bubble and quick sort methods
     */

    public static void sortTableBubbleIncreasing(int[] table)
    {
        long startTime = System.nanoTime();
        int swap = 0;
        do {
            swap = 0;
            for (int i = 0; i < table.length - 1; i++) {
                int x1 = table[i];
                int x2 = table[i + 1];

                if (x1 > x2) {
                    table[i] = x2;
                    table[i + 1] = x1;
                    swap++;
                }
            }
        }
        while (swap!=0);


        System.out.println("[BUBBLE/INCREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(table));
    }

    public static void sortTableBubbleIncreasingSkipSorted(int[] table)
    {
        long startTime = System.nanoTime();
        int swap = 0;
        int x = table.length-1;
        int n =0;
        do {
            swap = 0;

            for (int i = 0; i < x; i++) {
                int x1 = table[i];
                int x2 = table[i + 1];

                if (x1 > x2) {
                    table[i] = x2;
                    table[i + 1] = x1;
                    swap++;
                    n=i;
                }
            }
            x=n;
        }
        while (swap!=0);


        System.out.println("[BUBBLE_IMPROVED/INCREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(table));
    }

    public static void sortTableBubbleDecreasing(int[] table)
    {
        long startTime = System.nanoTime();
        int swap = 0;
        do {
            swap = 0;
            for (int i = 0; i < table.length - 1; i++) {
                int x1 = table[i];
                int x2 = table[i + 1];

                if (x1 < x2) {
                    table[i] = x2;
                    table[i + 1] = x1;
                    swap++;
                }
            }
        }
        while (swap!=0);


        System.out.println("[BUBBLE/DECREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(table));
    }

    public static void sortTableBubbleDecreasingSkipSorted(int[] table)
    {
        long startTime = System.nanoTime();
        int swap = 0;
        int x = table.length-1;
        int n =0;
        do {
            swap = 0;

            for (int i = 0; i < x; i++) {
                int x1 = table[i];
                int x2 = table[i + 1];

                if (x1 < x2) {
                    table[i] = x2;
                    table[i + 1] = x1;
                    swap++;
                    n=i;
                }
            }
            x=n;
        }
        while (swap!=0);


        System.out.println("[BUBBLE_IMPROVED/DECREASING] sorted in: "+String.valueOf(System.nanoTime()-startTime)+"ns "+Arrays.toString(table));
    }




    public static int[] sortTableQuickRecursiveIncreasing(int[] table, int start, int right)
    {
        long startTime = System.nanoTime();
        int x = partitionIncrement(table, start, right);

        // Recursively call quicksort with left part of the partitioned array
        if (start< x - 1) {
            sortTableQuickRecursiveIncreasing(table, start, x - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (right > x) {
            sortTableQuickRecursiveIncreasing(table, x, right);
        }


        return table;
    }

    private static int partitionIncrement(int[] arr,int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = swapTemp;


        //System.out.println(Arrays.toString(arr));
        return i + 1;

    }

    public static int[] sortTableQuickRecursiveDecreasing(int[] table, int start, int right)
    {
        long startTime = System.nanoTime();
        int x = partitionDecrement(table, start, right);

        // Recursively call quicksort with left part of the partitioned array
        if (start< x - 1) {
            sortTableQuickRecursiveDecreasing(table, start, x - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (right > x) {
            sortTableQuickRecursiveDecreasing(table, x, right);
        }


        return table;
    }
    private static int partitionDecrement(int[] arr,int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = swapTemp;


        //System.out.println(Arrays.toString(arr));
        return i + 1;

    }

    }


