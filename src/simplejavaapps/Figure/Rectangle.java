package simplejavaapps.Figure;

public class Rectangle implements FigureInterface{

    double a,b;

    public Rectangle(double a, double b)
    {
        this.a = a;
        this.b = b;
    }


    @Override
    public double getPerimeter() {
        return (2*a)+(2*b);
    }

    @Override
    public double getArea() {
        return a*b;
    }

    public double[] getLengths()
    {
        return new double[]{this.a,this.b};
    }
}
