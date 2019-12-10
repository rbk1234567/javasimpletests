package simplejavaapps;


import simplejavaapps.CommandCalc.CommandCalc;
import simplejavaapps.CommandCalc.CommandCalcFileLoader;
import simplejavaapps.FindMissing.FindMissing;
import simplejavaapps.Lambdas.Lambda;
import simplejavaapps.LifeGame.LifeGame;
import simplejavaapps.Lottery.CSVdeserializer;
import simplejavaapps.Lottery.Lottery;
import simplejavaapps.W3ExcercisesLVL1.W3ExcercisesLVL1;

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

        int[] table = RandomTableFactory.getRandomTable(1600, 0, 8);
        int[] table2 = new int[]{5, 2, 3, 1, 6};
        SortTable.sortTableBubbleIncreasing(Arrays.copyOf(table, table.length));
        SortTable.sortTableBubbleIncreasingSkipSorted(Arrays.copyOf(table, table.length));
        SortTable.sortTableBubbleDecreasing(Arrays.copyOf(table, table.length));
        SortTable.sortTableBubbleDecreasingSkipSorted(Arrays.copyOf(table, table.length));


        for (int i = 0; i < 1; i++) {


            long startTime = System.nanoTime();
            int[] result = SortTable.sortTableQuickRecursiveIncreasing(Arrays.copyOf(table, table.length), 0, table.length - 1);

            System.out.println("[QUICKSORT/INCREASING] sorted in: " + String.valueOf(System.nanoTime() - startTime) + "ns " + Arrays.toString(result));
        }


        for (int i = 0; i < 1; i++) {


            long startTime = System.nanoTime();
            int[] result = SortTable.sortTableQuickRecursiveDecreasing(Arrays.copyOf(table, table.length), 0, table.length - 1);

            System.out.println("[QUICKSORT/DECREASING] sorted in: " + String.valueOf(System.nanoTime() - startTime) + "ns " + Arrays.toString(result));
        }

        //ScannerInputCreateTable.createTable();
        //ScannerInputCreateTable.createTableNextInt();
        //InputCheck.checkInput();

        /*
        ChristmasTreeGenerator t = new ChristmasTreeGenerator();
        System.out.println(t.toString());

        ChristmasTreeGenerator t2 = new ChristmasTreeGenerator('.',' ',5,1,0);

        System.out.println(t2.toString());

         */

/*
        LifeGame lifeGame = new LifeGame();
        lifeGame.setCellLive(1, 0);
        lifeGame.setCellLive(2, 0);
        lifeGame.setCellLive(3, 0);

        System.out.println(lifeGame.toString());
        for (int i = 0; i < 5; i++) {
            lifeGame.nextGeneration();
            System.out.println(lifeGame.toString());
        }
*/


/*
        CSVdeserializer csVdeserializer = new CSVdeserializer();

        Lottery lottery = new Lottery(csVdeserializer.deserializeData(csVdeserializer.getFileStringData()));
        lottery.displayChances();
        for(int i=0;i<1;i++) {
            lottery.displayWinners(lottery.getWinners(-2));
            System.out.println("-------------------");
        }
*/

        CommandCalc.runCommandsFromFile("/home/rbk/IdeaProjects/simplebytes/src/simplejavaapps/CommandCalc/commands.txt");


        double[] tableWithMissingNumber = {4,3,2,1,0,-1,-2,-3,-5};
        FindMissing fm = new FindMissing();
        System.out.println("main: "+fm.findMissingNumber(tableWithMissingNumber));

        Lambda l = new Lambda();
        l.DisplayMessage("LAMBDA!!!");
        Lambda.doIt(null);

        W3ExcercisesLVL1.Excercise9();
        W3ExcercisesLVL1.Excercise11(7.5);

        W3ExcercisesLVL1.Excercise15(7.2,"Hello");

        //W3ExcercisesLVL1.Excercise17();

        //W3ExcercisesLVL1.Excercise18();

        //W3ExcercisesLVL1.Excercise19();

        //W3ExcercisesLVL1.Excercise20();

        //W3ExcercisesLVL1.Excercise21();

        //W3ExcercisesLVL1.Excercise22();

        //W3ExcercisesLVL1.Excercise23();

        //W3ExcercisesLVL1.Excercise24();

        //W3ExcercisesLVL1.Excercise25();

        //W3ExcercisesLVL1.Excercise26();

        //W3ExcercisesLVL1.Excercise27();

        //W3ExcercisesLVL1.Excercise28();

        W3ExcercisesLVL1.Excercise29();
    }


}
