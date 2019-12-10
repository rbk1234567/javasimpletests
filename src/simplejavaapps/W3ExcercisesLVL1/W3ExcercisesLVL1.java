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


    //binary to octal
    public static void Excercise24() {
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
                for (String s : splittedBinary) {
                    if (s.matches("0") | s.matches("1")) {

                    } else {
                        isBinary = false;
                        break;
                    }
                }
                if (isBinary == true) {
                    break;
                }

                System.out.println("Enter binary number:");


        }


        //calculate octal value
        for (int i=splittedBinary.length-1;i>=0;i--) {

            if(splittedBinary[i].matches("1")) {
                decimal = decimal + (int) Math.pow(2, powOfTwo);

            }

            powOfTwo++;

            if(powOfTwo==3 | i==0)
            {
                result.append(decimal);
                powOfTwo = 0;
                decimal = 0;
            }
        }

        System.out.println("Octal representation is: " + result.reverse().toString());
    }


    //octal to decimal
    public static void Excercise25() {
        int digit = 0;
        boolean isOctal = false;
        String octal;
        String[] splittedOctal = new String[0];
        int decimal = 0;
        int powOfEight = 0;
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter octal number:");

        //take input and check if it is an octal
        while (scanner.hasNext() == true && isOctal==false) {
            if(scanner.hasNextInt()) {
                isOctal = true;
                input = scanner.nextInt();
                octal = String.valueOf(input);

                splittedOctal = octal.split("");
                for (String s : splittedOctal) {
                    if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 8) {

                    } else {
                        isOctal = false;
                        break;
                    }
                }
                if (isOctal == true) {
                    break;
                }
            }else {
                scanner.next();
                isOctal = false;
            }
            System.out.println("Enter octal number:");
        }

        //calculate octal value
        for (int i=splittedOctal.length-1;i>=0;i--) {
            {
                decimal = decimal + Integer.parseInt(splittedOctal[i])*(int) Math.pow(8, powOfEight);

            }
            powOfEight++;
        }

        System.out.println("Decimal representation is: " + decimal);
    }


    //octal to binary
    public static void Excercise26() {
        int digit = 0;
        boolean isOctal = false;
        String octal;
        String[] splittedOctal = new String[0];
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter octal number:");

        //take input and check if it is an octal
        while (scanner.hasNext() == true && isOctal==false) {
            if(scanner.hasNextInt()) {
                isOctal = true;
                input = scanner.nextInt();
                octal = String.valueOf(input);

                splittedOctal = octal.split("");
                for (String s : splittedOctal) {
                    if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 8) {

                    } else {
                        isOctal = false;
                        break;
                    }
                }
                if (isOctal == true) {
                    break;
                }
            }else {
                scanner.next();
                isOctal = false;
            }
            System.out.println("Enter octal number:");
        }

        //calculate binary value
        StringBuilder binary = new StringBuilder();

        for (int i = splittedOctal.length-1;i>=0;i--
             ) {
            int value = (int) (Integer.parseInt(splittedOctal[i]));
            while (value>0) {
                digit = value % 2;
                binary.append(digit);
                value = (value - digit) /2;
            }

        }



        System.out.println("Binary representation is: " + binary.reverse().toString());
    }

    //octal to hexadecimal
    public static void Excercise27() {

        int digit = 0;
        int decimal = 0;
        boolean isOctal = false;
        String octal;
        String[] splittedOctal = new String[0];
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter octal number:");

        //take input and check if it is an octal
        while (scanner.hasNext() == true && isOctal==false) {
            if(scanner.hasNextInt()) {
                isOctal = true;
                input = scanner.nextInt();
                octal = String.valueOf(input);

                splittedOctal = octal.split("");
                for (String s : splittedOctal) {
                    if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 8) {

                    } else {
                        isOctal = false;
                        break;
                    }
                }
                if (isOctal == true) {
                    break;
                }
            }else {
                scanner.next();
                isOctal = false;
            }
            System.out.println("Enter octal number:");
        }

        //calculate hexadecimal value
        StringBuilder hex = new StringBuilder();
        int powerOfEight = 0;

        //step1. calculate decimal value
        for(int i=splittedOctal.length-1;i>=0;i--)
        {
            decimal = decimal + (int) (Integer.parseInt(splittedOctal[i])*Math.pow(8,powerOfEight));
            powerOfEight++;
        }
        //step2. calculate hex value
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

    //hexadecimal to decimal
    public static void Excercise28() {

        String input = "";
        Scanner scanner = new Scanner(System.in);
        String[] splittedInput = new String[0];
        boolean isHex = false;
        int decimal = 0;
        int digit = 0;
        int powOfSixteen = 0;


        System.out.println("Enter hexadecimal number:");

        //check if input is a hexadecimal number
        while(scanner.hasNextLine() && isHex==false)
        {
            if(scanner.hasNext()) {
                isHex = true;
                input = scanner.next();


                splittedInput = input.toUpperCase().split("");
                String[] hexChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

                for (String sign : splittedInput) {
                    for (int i = 0; i < hexChars.length; i++) {
                        if (sign.matches(hexChars[i])) {
                            isHex = true;
                            break;
                        }
                        isHex = false;
                    }
                    if (isHex != true) {
                        System.out.println("Enter hexadecimal number:");
                        break;
                    }
                }
            }else {
                scanner.next();
                isHex = false;
            }

        }

            for (int i = splittedInput.length-1;i>=0;i--) {
                switch (splittedInput[i]) {
                    case "A":
                        digit = 10;
                        break;
                    case "B":
                        digit = 11;
                        break;
                    case "C":
                        digit = 12;
                        break;
                    case "D":
                        digit = 13;
                        break;
                    case "E":
                        digit = 14;
                        break;
                    case "F":
                        digit = 15;
                        break;
                    default:
                        digit = Integer.parseInt(splittedInput[i]);
                        break;

                }
                digit = digit * (int)Math.pow(16,powOfSixteen);
                powOfSixteen++;
                decimal = decimal + digit;
            }



        System.out.println("Decimal representation is: "+decimal);
    }

    //hexadecimal to binary
    public static void Excercise29() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        String[] splittedInput = new String[0];
        boolean isHex = false;
        StringBuilder result = new StringBuilder();
        String[] binaryTable = new String[] {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};


        System.out.println("Enter hexadecimal number:");

        //check if input is a hexadecimal number and assign result
        while(scanner.hasNextLine() && isHex==false)
        {
            if(scanner.hasNext()) {
                isHex = true;
                input = scanner.next();


                splittedInput = input.toUpperCase().split("");

                String[] hexChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

                for (String sign : splittedInput) {
                    for (int i = 0; i < hexChars.length; i++) {
                        if (sign.matches(hexChars[i])) {
                            isHex = true;
                            result.append(binaryTable[i]);
                            break;
                        }
                        isHex = false;
                    }
                    if (isHex != true) {
                        result.setLength(0);
                        System.out.println("Enter hexadecimal number:");
                        break;
                    }
                }
            }else {
                scanner.next();
                isHex = false;
            }

        }

        System.out.println("Binary representation is: "+result.toString());




    }
}
