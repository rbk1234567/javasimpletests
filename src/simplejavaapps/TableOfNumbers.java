package simplejavaapps;

import java.util.Arrays;

public class TableOfNumbers {

    /*
    gets table of int and displays as [int1, int2, int3 ...]
     */

    public static void displayNumbersFromTable(int[] table)
    {
        StringBuilder stringBuilder = new StringBuilder();


        for (int i:table)
        {
        stringBuilder.append(i+",");
        }

        System.out.println(String.format("[%s]",stringBuilder.toString().substring(0,stringBuilder.length()-1)));

        //System.out.println(Arrays.toString(table));
    }
}
