package simplejavaapps;

public class Palindrome {

    public static void isPalindrome(String word)
    {
        boolean result = false;
        for(int i = 0;i<=((int)word.length()/2);i++)
        {
            if(!String.valueOf(word.charAt(i)).equalsIgnoreCase(String.valueOf(word.charAt(word.length()-1-i))))
            {
                break;
            }
            else
            {
                result = true;
            }
        }
        if (result == true) {
            System.out.println(String.format("\"%s\"",word)+ " It is a palindrome");
        } else {
            System.out.println(String.format("\"%s\"",word)+ " It is not a palindrome");
        }
    }
}
