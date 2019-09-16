package simplejavaapps;

public class RandomTableFactory {

    public static int[] getRandomTable(int size, int min, int max) {
        int[] table = new int[size];

        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }


            int negativeVal1 = (min < 0) ? 1 : 0;
            int negativeVal2 = (min < 0 & max > 0) ? 1 : 0;

            for (int i = 0; i < table.length; i++) {
                double x = ((Math.random() * ((max - min) + 1 + negativeVal2)) + min - negativeVal1);
                table[i] = (int) x;
            }




        return table;
    }


    public static int generatRandomPositiveNegitiveValue(int max, int min) {
        //Random rand = new Random();
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        return ii;
    }


}
