package simplejavaapps.W3ExcercisesLVL1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class W3ExcercisesLVL1 {

    // just make simple calculation
    public static double Excercise9()
    {
        double x = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
        System.out.println(x);
        return x;
    }

    // return area and perimeter of circle with given radius
    public static List<Object> Excercise11(double radius)
    {
        double area = Math.PI*Math.pow(radius,2);
        double perimeter = 2*Math.PI*radius;

        List<Object> result = Arrays.asList(area,perimeter);
        return result;
    }

    // takes 3 numbers and return average value
    public static double Excercise12(double x,double y, double z)
    {
        return (x+y+z)/3;
    }

    public static List<Object> Excercise13(double x,double y)
    {
        Double area = x*y;
        Double perimeter = (x+y)*2;
        return Arrays.asList(area,perimeter);
    }

    //swap variables
    public static List<Object> Excercise15(Object o1, Object o2)
    {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
        return Arrays.asList(o1,o2);
    }

}
