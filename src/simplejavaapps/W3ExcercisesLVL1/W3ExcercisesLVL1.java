package simplejavaapps.W3ExcercisesLVL1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class W3ExcercisesLVL1 {

    // just make simple calculation
    public static double Excercise9() {
        double x = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
        System.out.println(x);
        return x;
    }

    // return area and perimeter of circle with given radius
    public static List<Object> Excercise11(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        List<Object> result = Arrays.asList(area, perimeter);
        return result;
    }

    // takes 3 numbers and return average value
    public static double Excercise12(double x, double y, double z) {
        return (x + y + z) / 3;
    }

    public static List<Object> Excercise13(double x, double y) {
        Double area = x * y;
        Double perimeter = (x + y) * 2;
        return Arrays.asList(area, perimeter);
    }

    //swap variables
    public static List<Object> Excercise15(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
        return Arrays.asList(o1, o2);
    }

    //add two binary numbers and return result as binary number
    public static void Excercise17() {
        Scanner scanner = new Scanner(System.in);
        int b1, b2;

        do {
            System.out.print("Input first binary: ");
            b1 = scanner.nextInt();
        } while (!CheckBinary.isBinary(b1));

        do {
            System.out.print("Input second binary: ");
            b2 = scanner.nextInt();
        } while (!CheckBinary.isBinary(b2));

        System.out.println(String.format("B1: %d + B2:%d", b1, b2));


        System.out.println(String.format("BINARY SUM: %s", AddBinaries(b1, b2)));

    }

    static String AddBinaries(int b1, int b2) {
        if (!CheckBinary.isBinary(b1) | !CheckBinary.isBinary(b2)) {
            throw new NumberFormatException("This is not binary number");
        }
        ;
        int digit = 0;
        int remainder = 0;
        StringBuilder b = new StringBuilder();
        while (b1 > 0 | b2 > 0) {
            digit = (b1 % 10) + (b2 % 10) + remainder;
            remainder = 0;
            if (digit >= 2) {
                remainder = 1;
                digit = digit == 3 ? 1 : 0;
            }
            b.append(digit);
            //digit = 0;
            b1 = b1 / 10;
            b2 = b2 / 10;
        }
        if (remainder == 1) {
            b.append(remainder);
        }
        if (b.toString().length() == 0) {
            b.append(0);
        }

        return b.reverse().toString();
    }

    // multiple two binary numbers
    public static void Excercise18() {
        Scanner scanner = new Scanner(System.in);
        int b1, b2;

        do {
            System.out.print("Input first binary: ");
            b1 = scanner.nextInt();
        } while (!CheckBinary.isBinary(b1));

        do {
            System.out.print("Input second binary: ");
            b2 = scanner.nextInt();
        } while (!CheckBinary.isBinary(b2));

        System.out.println(String.format("B1: %d B2:%d", b1, b2));


        StringBuilder b = new StringBuilder();

        int small = (b1 > b2) ? b2 : b1;
        int big = (b1 < b2) ? b2 : b1;

        String m = String.valueOf(small);
        int result = 0;

        for (int i = m.length() - 1; i >= 0; i--) {

            if (String.valueOf(m.charAt(i)).matches("1")) {
                b.setLength(0);
                b.append(big);
                for (int c = (m.length() - 1 - i); c > 0; c--) {
                    b.append("0");
                }

                result = Integer.parseInt(AddBinaries(result, Integer.parseInt(b.toString())));
            }


        }


        System.out.println(String.format("MULTIPLY digit: %s", result));
    }

    //convert decimal to binary
    public static void Excercise19() {
        int digit = 0;
        int decimal = 0;


        Scanner scanner = new Scanner(System.in);
        StringBuilder binary = new StringBuilder();
        System.out.println("Enter decimal number:");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt() == true) {
                decimal = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.out.println("Enter decimal number:");
            }
        }

        if (decimal == 0) {
            binary.append(0);
        } else {
            while (decimal > 0) {
                digit = decimal % 2;
                binary.append(digit);
                decimal = (decimal - digit) / 2;

            }
        }
        System.out.println("Binary representation is: " + binary.reverse().toString());
    }

    static class CheckBinary {
        public static boolean isBinary(int number) {
            boolean isBinary = true;

            while (true) {
                if (number == 0) {
                    break;
                } else {
                    int digit = number % 10;

                    if (digit > 1) {
                        isBinary = false;
                        break;
                    }
                    number = number / 10;

                }
            }
            return isBinary;
        }
    }

    //decimal to hex
    public static void Excercise20() {
        int digit = 0;
        int decimal = 0;


        Scanner scanner = new Scanner(System.in);
        StringBuilder hex = new StringBuilder();
        System.out.println("Enter decimal number:");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt() == true) {
                decimal = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.out.println("Enter decimal number:");
            }
        }

        if (decimal == 0) {
            hex.append(0);
        } else {
            while (decimal > 0) {
                digit = decimal % 16;
                if (digit < 10) {
                    hex.append(digit);
                } else {
                    switch (digit) {
                        case 10:
                            hex.append("A");
                            break;
                        case 11:
                            hex.append("B");
                            break;
                        case 12:
                            hex.append("C");
                            break;
                        case 13:
                            hex.append("D");
                            break;
                        case 14:
                            hex.append("E");
                            break;
                        case 15:
                            hex.append("F");
                            break;

                    }
                }
                decimal = (decimal - digit) / 16;

            }
        }
        System.out.println("Hexadecimal representation is: " + hex.reverse().toString());
    }


    //decimal to octal
    public static void Excercise21() {
        int digit = 0;
        int decimal = 0;


        Scanner scanner = new Scanner(System.in);
        StringBuilder octal = new StringBuilder();
        System.out.println("Enter decimal number:");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt() == true) {
                decimal = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.out.println("Enter decimal number:");
            }
        }

        if (decimal == 0) {
            octal.append(0);
        } else {
            while (decimal > 0) {
                digit = decimal % 8;
                octal.append(digit);
                decimal = (decimal - digit) / 8;
            }
        }
        System.out.println("Octal representation is: " + octal.reverse().toString());
    }

    //binary to decimal
    public static void Excercise22() {
        int digit = 0;
        String binary;
        String[] splittedBinary = new String[0];
        int decimal = 0;
        int powOfTwo = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary number:");

        //take input and check if it is a binary
        while (scanner.hasNext() == true) {
            boolean isBinary = true;
            binary = scanner.next();

            splittedBinary = binary.split("");
            for (String s : splittedBinary)
            {
                if (s.matches("0") | s.matches("1")) {

                }
                else {
                    isBinary = false;
                    break;
                }
            }
            if(isBinary==true)
            {
                break;
            }
            System.out.println("Enter binary number:");

        }

        //calculate decimal value
        for (int i=splittedBinary.length-1;i>=0;i--) {
            if(splittedBinary[i].matches("1")) {
                decimal = decimal + (int) Math.pow(2, powOfTwo);

            }
            powOfTwo++;
        }

        System.out.println("Decimal representation is: " + decimal);
    }


    //binary to hexadecimal
    public static void Excercise23() {
        int digit = 0;
        String binary;
        String[] splittedBinary = new String[0];
        int decimal = 0;
        int powOfTwo = 0;

        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary number:");

        //take input and check if it is a binary
        while (scanner.hasNext() == true) {
            boolean isBinary = true;
            binary = scanner.next();

            splittedBinary = binary.split("");
            for (String s : splittedBinary)
            {
                if (s.matches("0") | s.matches("1")) {

                }
                else {
                    isBinary = false;
                    break;
                }
            }
            if(isBinary==true)
            {
                break;
            }
            System.out.println("Enter binary number:");

        }


        //calculate hexadecimal value
        for (int i=splittedBinary.length-1;i>=0;i--) {

            if(splittedBinary[i].matches("1")) {
                decimal = decimal + (int) Math.pow(2, powOfTwo);

            }

            powOfTwo++;

            if(powOfTwo==4 | i==0)
            {
                if(decimal<10)
                {
                    result.append(decimal);
                }
                else {
                    switch(decimal)
                    {
                        case 10:
                            result.append("A");
                            break;
                        case 11:
                            result.append("B");
                            break;
                        case 12:
                            result.append("C");
                            break;
                        case 13:
                            result.append("D");
                            break;
                        case 14:
                            result.append("E");
                            break;
                        case 15:
                            result.append("F");
                            break;
                    }
                }
                powOfTwo = 0;
                decimal = 0;
            }
        }

        System.out.println("Hexadecimal representation is: " + result.reverse().toString());
    }

}
