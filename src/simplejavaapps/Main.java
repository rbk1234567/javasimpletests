package simplejavaapps;


public class Main {


    public static void main(String[] args) {

    //NWW.runTest();
    //Counter.CountFromZeroTo(10);
    //Counter.CountFromNumberToZero(10);
    //Counter.CountForwardXToY(3,10);
    Counter.CountBackwardYToX(3,10);

    ArrayFactory arrayFactory = new ArrayFactory(5);
    arrayFactory.oneDimension();
    arrayFactory.twoDimension();


    }
}
