package Figure;

public class Circle implements FigureInterface {

    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.radius;
    }

    @Override
    public double getArea() {
        return (Math.PI*(Math.pow(this.radius,2)))/2;
    }

    @Override
    public double[] getLengths(){
        return new double[]{this.radius};
    }
}
