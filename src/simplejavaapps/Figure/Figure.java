package simplejavaapps.Figure;


import java.util.Arrays;
import java.util.Scanner;

public class Figure {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Circle circle = null;
        Triangle triangle = null;
        Rectangle rectangle = null;
        FigureInterface[] table = new FigureInterface[3];

        //create Circle
        table[0] = new Circle(getScannerInputDouble(Circle.class.getSimpleName()));

        //create Triangle
        double[] triangleLengths = new double[]{Double.NaN,Double.NaN,Double.NaN};
        triangleLengths[0] = getScannerInputDouble(Triangle.class.getSimpleName());
        triangleLengths[1] = getScannerInputDouble(Triangle.class.getSimpleName());
        if(isTriangleThirdSideNeeded())
        {
            triangleLengths[2] = getScannerInputDouble(Triangle.class.getSimpleName());
        }
        table[1] = new Triangle(triangleLengths);

        //create Rectangle
        table[2] = new Rectangle(getScannerInputDouble(Rectangle.class.getSimpleName()),getScannerInputDouble(Rectangle.class.getSimpleName()));

        //display results
        for(FigureInterface f:table)
        {
            System.out.println("Class: "+f.getClass().getSimpleName()+" Perimeter: "+f.getPerimeter()+" Area: "+f.getArea()+" Lengths: "+ Arrays.toString(f.getLengths()));
        }

    }

    private static boolean isTriangleThirdSideNeeded()
    {
        boolean answer = false;
        System.out.println("Is third side length of a triangle is known? y/n");
        while (scanner.hasNext())
        {
            if(scanner.next().equalsIgnoreCase("y"))
            {
                answer = true;
                break;
            }
            else {break;}

        }
        return answer;
    }

    private static double getScannerInputDouble(String className) {
        double input;
        String inputName;

        switch (className.toLowerCase()){
            case "circle":{
                inputName = "radius";
                break;
            }
            case "triangle" :case "rectangle":{
                inputName = "side length";
                break;
            }
            default:{
                inputName = "value";
                break;
            }

        }
        System.out.println("Enter "+className+" "+inputName+":");
        while (!scanner.hasNextDouble()) {
            System.out.println(scanner.next() + "is not a number. Enter "+inputName+":");
        }

            input = Math.abs(scanner.nextDouble());


        return input;
    }



}
