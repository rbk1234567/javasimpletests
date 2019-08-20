package simplejavaapps;

public class ArrayFactory {

    int arraySize = 0;

    public ArrayFactory(int arraySize)
    {
        this.arraySize = arraySize;
    }

    public int[] oneDimension()
    {
        return new int[arraySize];
    }

    public int[][] twoDimension()
    {
        return new int[arraySize][arraySize];
    }

}
