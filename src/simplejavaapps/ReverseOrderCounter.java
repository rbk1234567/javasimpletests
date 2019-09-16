package simplejavaapps;

public class ReverseOrderCounter {

    public static void displayInReverseOrder(int number)
    {
        String value = String.valueOf(number);
        for(int i = value.length()-1;i>=0;i--)
        {
            System.out.println(value.charAt(i));
        }
    }
}
