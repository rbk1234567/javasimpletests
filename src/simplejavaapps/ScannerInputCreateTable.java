package simplejavaapps;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerInputCreateTable {

    /*
    creates table with defined size and fills it with provided values
     */

    public static void createTable() {

        /*
        version with try/catch (parsing input)
         */

        Scanner scanner = new Scanner(System.in);
        int tableSize = 0;
        int[] table;


        System.out.println("Enter size of a table:");

        while (scanner.hasNext()) {

            String value = scanner.next();
            try {
                tableSize = getIntFromScannerInput(value);
                if(tableSize>=0) {
                    break;
                }
                else {
                    System.out.println("Number must be greater or equal 0. Enter size of a table");
                }
            } catch (NumberFormatException e) {
                System.out.println(String.format("\"%s\"", value) + " is not an integer. Enter size of a table:");
            }


        }
        table = new int[tableSize];

        if(tableSize>0)
        {
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Enter value to position [" + i + "].");
            while (scanner.hasNext() == true) {

                String value = scanner.next();
                try {
                    table[i] = getIntFromScannerInput(value);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(String.format("\"%s\"", value) + " is not an integer. Enter value to position [" + i + "].");
                }
            }
        }

        }
        System.out.println("END with table size: " + tableSize);
        System.out.println(Arrays.toString(table));
    }


    private static int getIntFromScannerInput(String input) throws NumberFormatException {
        int val = 0;

        try {
            return val = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }


    public static void createTableNextInt() {

        /*
        Version without try/catch (NumberFormatException)
         */
        Scanner scanner = new Scanner(System.in);
        int tableSize = 0;
        int[] table;

        System.out.println("Enter size of a table:");

        while(!scanner.hasNextInt())
        {
            System.out.println(String.format("\"%s\"", scanner.next()) + " is not an integer. Enter size of a table:");
        }
        while (scanner.hasNextInt()) {

            tableSize = Integer.parseInt(scanner.next());
            if(tableSize>=0)
            {
                break;
            }
            else
            {
                System.out.println("Number must be greater or equal 0. Enter size of a table");
            }

        }
        table = new int[tableSize];

        if(tableSize>0)
        {
            for (int i = 0; i < tableSize; i++) {
                System.out.println("Enter value to position [" + i + "].");

                while (!scanner.hasNextInt())
                {
                    System.out.println(String.format("\"%s\"", scanner.next()) + " is not an integer. Enter value to position [" + i + "].");
                }
                    table[i] = Integer.parseInt(scanner.next());
            }

        }
        System.out.println("END with table size: " + tableSize);
        System.out.println(Arrays.toString(table));
    }
}
