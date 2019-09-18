package simplejavaapps.Figure;

public class Triangle implements FigureInterface{

    double a,b,c;


    public Triangle(double[] triangleLengths) {
        this.a = triangleLengths[0];
        this.b = triangleLengths[1];
        if(!Double.isNaN(triangleLengths[2]))
        {
            this.c = triangleLengths[2];
        }
        else
        {
            this.c = Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2));
        }
    }


    @Override
    public double getPerimeter() {
        return this.a+this.b+this.c;
    }

    @Override
    public double getArea() {
        double s = (this.a+this.b+this.c)/2;
        return Math.sqrt(s*(s-this.a)*(s-this.b)*(s-this.c));
    }

    public double[] getLengths(){
        return new double[]{this.a,this.b,this.c};
    }
}
