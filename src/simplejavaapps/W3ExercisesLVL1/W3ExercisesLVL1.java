package simplejavaapps.W3ExercisesLVL1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class W3ExercisesLVL1 {

    // just make simple calculation
    public static double Exercise9() {
        double x = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
        System.out.println(x);
        return x;
    }

    // return area and perimeter of circle with given radius
    public static List<Object> Exercise11(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        List<Object> result = Arrays.asList(area, perimeter);
        return result;
    }

    // takes 3 numbers and return average value
    public static double Exercise12(double x, double y, double z) {
        return (x + y + z) / 3;
    }

    public static List<Object> Exercise13(double x, double y) {
        Double area = x * y;
        Double perimeter = (x + y) * 2;
        return Arrays.asList(area, perimeter);
    }

    //swap variables
    public static List<Object> Exercise15(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
        return Arrays.asList(o1, o2);
    }

    //add two binary numbers and return result as binary number
    public static void Exercise17() {
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
    public static void Exercise18() {
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
    public static void Exercise19() {
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
    public static void Exercise20() {
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
    public static void Exercise21() {
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
    public static void Exercise22() {
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
    public static void Exercise23() {
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
    public static void Exercise24() {
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
    public static void Exercise25() {
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
    public static void Exercise26() {
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
    public static void Exercise27() {

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
    public static void Exercise28() {

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
    public static void Exercise29() {
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

    //hexadecimal to octal
    public static void Exercise30() {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        String[] splittedInput = new String[0];
        boolean isHex = false;
        StringBuilder result = new StringBuilder();
        String[] binaryTable = new String[] {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String[] octalTable = new String[]{"000","001","010","011","100","101","110","111"};


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

        String binary = result.toString();
        StringBuilder partialResult = new StringBuilder();
        result.setLength(0);

        for(int i=(3-(binary.length())%3);i>0;i--)
        {
            result.append("0");
        }
        splittedInput = result.append(binary).toString().split("");
        result.setLength(0);

        for(int i = splittedInput.length-1;i>=0; )
        {
            for(int x=3;x>0;x--)
            {
                partialResult.append(splittedInput[i]);
                i--;
            }
            String partialInverted = partialResult.reverse().toString();
            for(int y=0;y<octalTable.length-1;y++)
            {
                if(octalTable[y].matches(partialInverted))
                {
                    result.append(y);
                    partialResult.setLength(0);
                    break;
                }
            }
        }


        System.out.println("Octal representation is: "+result.reverse().toString());

    }

    // Show java version
    public static void Exercise31()
    {
        System.out.println("Current JAVA version is: "+System.getProperty("java.version"));
        System.out.println("Current JAVA vendor is: "+System.getProperty("java.vm.vendor"));

        /*
        get system properties with System.getProperties().list(System.out);
         */
    }

    // take two numbers and show comparison
    public static void Exercise32()
    {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = 0;
        int secondNumber = 0;
        int iterator = 1;

        System.out.println("--- Exercise 32 ---");

        do {
            System.out.println(String.format("Enter %d number:",iterator));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt() == true) {
                    int number = scanner.nextInt();

                    iterator++;
                    firstNumber = iterator==2?number:firstNumber;
                    secondNumber = iterator==3?number:secondNumber;
                    break;

                } else {
                    scanner.next();
                    System.out.println(String.format("Enter %d number:",iterator));
                }
            }
        }while (iterator<3);

        System.out.println(String.format("First number is %d and second number is %d",firstNumber,secondNumber));


        if(firstNumber==secondNumber)
        {
            System.out.println(String.format("%d == %d",firstNumber,secondNumber));
        }else{
            System.out.println(String.format("%d != %d",firstNumber,secondNumber));
            if(firstNumber<secondNumber)
            {
                System.out.println(String.format("%d < %d",firstNumber,secondNumber));
            }else
            {
                System.out.println(String.format("%d > %d",firstNumber,secondNumber));
            }
        }

    }

    // take number and sum digits
    public static void Exercise33()
    {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int result = 0;

        System.out.println("--- Exercise 33 ---");


            System.out.println("Enter number:");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt() == true) {
                    number = scanner.nextInt();
                    break;

                } else {
                    scanner.next();
                    System.out.println("Enter number:");
                }
            }

            number = number<0?Math.abs(number):number;
            String[] splitted = String.valueOf(number).split("");

        for (String s:splitted
             ) {
            result = result+Integer.parseInt(s);
        }

        System.out.println(String.format("Sum of %d digits of number %d is %d",splitted.length,number,result));
    }

    // calculate area of hexagon
    public static void Exercise34()
    {
        Scanner scanner = new Scanner(System.in);
        int side = 0;
        double area = 0;

        System.out.println("--- Exercise 34 ---");


        System.out.println("Enter side lenght:");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt() == true) {
                side = scanner.nextInt();
                break;

            } else {
                scanner.next();
                System.out.println("Enter side lenght:");
            }
        }

        area = (6*Math.pow(side,2)/(4*Math.tan(Math.PI/6)));
        System.out.println(String.format("Area of hexagon with side lenght %d is: %f",side,area));


    }

    // calculate area of n-gon
    public static void Exercise35()
    {
        Scanner scanner = new Scanner(System.in);
        int side = 0;
        int n = 0;
        double area = 0;
        int iterator = 1;
        String[] varNames = new String[]{"side lenght: ","number of sides: "};

        System.out.println("--- Exercise 35 ---");

        do {
            System.out.println("Enter "+varNames[iterator-1]);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt() == true) {
                    int number = Math.abs(scanner.nextInt());

                    iterator++;
                    side = iterator==2?number:side;
                    n = iterator==3?number:n;
                    break;

                } else {
                    scanner.next();
                    System.out.println("Enter "+varNames[iterator-1]);
                }
            }
        }while (iterator<3);

        area = (n*Math.pow(side,2)/(4*Math.tan(Math.PI/n)));
        System.out.println(String.format("Area of %d-gon with side lenght %d is: %f",n,side,area));


    }

    //calculate distance between two coordinates (input in degrees)
    public static void Exercise36()
    {
        Scanner scanner = new Scanner(System.in);
        final double PLANET_RADIUS = 6371.01;
        double xLat = 0;
        double xLon = 0;
        double yLat = 0;
        double yLon = 0;
        double distance = 0;
        int iterator = 0;
        double minCoordValue = -90;
        double maxCoordValue = 90;
        String[] varNames = new String[]{"first point latitude: ","first point longtitude: ","second point latitude: ","second point longtitude: "};

        System.out.println("--- Exercise 36 ---");

        do {
            System.out.println(String.format("Enter "+varNames[iterator]+" (coordinates range[%.0f/%.0f])",minCoordValue,maxCoordValue));
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble() == true) {
                    double number = scanner.nextDouble();

                    boolean isIteratorEven = iterator%2!=0?false:true;
                    minCoordValue=isIteratorEven?-90:-180;
                    maxCoordValue=isIteratorEven?90:180;

                    boolean isValid = number >= minCoordValue && number <= maxCoordValue;

                    if(isValid) {
                        switch (iterator) {
                            case 0: {
                                xLat = Math.toRadians(number);
                                iterator++;
                                minCoordValue-=90;
                                maxCoordValue+=90;
                                break;
                            }
                            case 1: {
                                xLon = Math.toRadians(number);
                                iterator++;
                                minCoordValue+=90;
                                maxCoordValue-=90;
                                break;
                            }
                            case 2: {
                                yLat = Math.toRadians(number);
                                iterator++;
                                minCoordValue-=90;
                                maxCoordValue+=90;
                                break;
                            }
                            case 3: {
                                yLon = Math.toRadians(number);
                                iterator++;
                                minCoordValue+=90;
                                maxCoordValue-=90;
                                break;
                            }
                            default: {
                            }
                        }
                        break;
                    }
                    else {
                        System.out.println(String.format("Incorrect value. Enter "+varNames[iterator]+" (coordinates range[%.0f/%.0f])",minCoordValue,maxCoordValue));
                    }
                }
                else {
                    scanner.next();
                    System.out.println(String.format("Enter "+varNames[iterator]+" (coordinates range[%.0f/%.0f])",minCoordValue,maxCoordValue));

                }
            }
        }while (iterator<4);

        //d = radius * arccos(sin(P1x) * sin(P2x) + cos(P1x) * cos(P2x) * cos(P1y - P2y))
        distance = PLANET_RADIUS*Math.acos(Math.sin(xLat)*Math.sin(yLat)+Math.cos(xLat)*Math.cos(yLat)*Math.cos(xLon-yLon));

        System.out.println(String.format("Distance between [%.2f/%.2f] and [%.2f/%.2f] is %.2f km",Math.toDegrees(xLat),Math.toDegrees(xLon),Math.toDegrees(yLat),Math.toDegrees(yLon),distance));
    }



}
