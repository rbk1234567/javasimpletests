package simplejavaapps.FindMissing;

public class FindMissing {
    /*
    find missing number (between first and last number) in arithmetic progression (increasing or decreasing order is a must) data table
    provided data must be valid (if no number is missing no error will be thrown but result will be invalid)
    works for negative numbers too
    */

    public static double findMissingNumber(double[] dataTable)
    {
        double expectedSum = 0;

            if (dataTable[0] == 0) {
                expectedSum = ((dataTable[1] + dataTable[dataTable.length - 1]) / 2) * (dataTable.length);
            } else {
                expectedSum = ((dataTable[0] + dataTable[dataTable.length - 1]) / 2) * (dataTable.length + 1);
            }
            System.out.println("calc sum: " + expectedSum);


        double sum = 0;

        for (double i: dataTable
             ) {
            sum = sum+i;
        }


        return (expectedSum - sum);
    }



}
