package simplejavaapps.W3ExercisesLVL1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class W3ExercisesLVL1Test {

    @Test
    void Exercise9() {
        Assertions.assertEquals(2.138888888888889,W3ExercisesLVL1.Exercise9());
    }

    @Test
    void Exercise11() {
        List<Object> result = W3ExercisesLVL1.Exercise11(7.5);
        Double area = (Double) result.get(0);
        Double perimeter = (Double) result.get(1);
        Assertions.assertEquals(176.71458676442586 ,area);
        Assertions.assertEquals(47.12388980384689 ,perimeter);
    }

    @Test
    void Exercise12() {
        Assertions.assertEquals(4,W3ExercisesLVL1.Exercise12(1,4,7));

    }

    @Test
    void Exercise13() {
        List<Object> result = W3ExercisesLVL1.Exercise13(5.5,8.5);
        Double area = (Double) result.get(0);
        Double perimeter = (Double) result.get(1);
        Assertions.assertEquals(46.75 ,area);
        Assertions.assertEquals(28 ,perimeter);
    }

    @Test
    void Exercise15() {

        double o1 = 7.5;
        String o2 = "Hello";
        List<Object> result = W3ExercisesLVL1.Exercise15(o1,o2);
        Assertions.assertEquals(7.5,result.get(1));
        Assertions.assertEquals("Hello",result.get(0));

    }


    @Test
    void addBinaries() {

        int b1 = 101;
        int b2 = 10111;
        int b3 = 000000;
        int b4 = 111111;

        Assertions.assertEquals("11100",W3ExercisesLVL1.AddBinaries(b1,b2));
        Assertions.assertEquals("1010",W3ExercisesLVL1.AddBinaries(b1,b1));
        Assertions.assertEquals("101110",W3ExercisesLVL1.AddBinaries(b2,b2));
        Assertions.assertEquals("0",W3ExercisesLVL1.AddBinaries(b3,b3));
        Assertions.assertEquals("1111110",W3ExercisesLVL1.AddBinaries(b4,b4));
        Assertions.assertEquals("111111",W3ExercisesLVL1.AddBinaries(b4,b3));

    }
}