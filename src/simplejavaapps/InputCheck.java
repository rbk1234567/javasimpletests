package simplejavaapps;

import java.util.Scanner;

public class InputCheck {

    /*
    Displays lenght of an input
    Check if input is palindrome
    Displays anagram of input
     */

    public static void checkInput()
    {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.println("Enter text:");
        while (scanner.hasNext())
        {
            input = scanner.next();
            System.out.println("Text lenght: "+input.length());
            Palindrome.isPalindrome(input);
            Anagram.getAnagram(input);
            System.out.println("Enter text:");
        }




    }



}
