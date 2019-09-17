package simplejavaapps;

public class Counter {

    /*
    Multiple counting methods
     */

    public static void CountFromZeroTo(int number)
    {
        for(int i=0;i<=number;i++)
        {
            System.out.println(i);
        }
    }

    public static void CountFromNumberToZero(int number)
    {
        for(int i=number;i>=0;i--)
        {
            System.out.println(i);
        }
    }

    public static void CountForwardXToY(int x,int y)
    {
        for(int i=x;i<=y;i++)
        {
            System.out.println(i);
        }
    }

    public static void CountBackwardYToX(int x,int y)
    {
        for(int i=y;i>=x;i--)
        {
            System.out.println(i);
        }
    }
}
