package simplejavaapps;

public class ReverseOrderCounter {

    /*
    displays numbers digits in reverse order
     */

    public static void displayInReverseOrder(int number)
    {
        String value = String.valueOf(number);
        for(int i = value.length()-1;i>=0;i--)
        {
            System.out.println(value.charAt(i));
        }
    }
}
