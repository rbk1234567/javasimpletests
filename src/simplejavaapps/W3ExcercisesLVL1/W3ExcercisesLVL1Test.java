package simplejavaapps.W3ExcercisesLVL1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class W3ExcercisesLVL1Test {

    @Test
    void excercise9() {
        Assertions.assertEquals(2.138888888888889,W3ExcercisesLVL1.Excercise9());
    }

    @Test
    void excercise11() {
        List<Object> result = W3ExcercisesLVL1.Excercise11(7.5);
        Double area = (Double) result.get(0);
        Double perimeter = (Double) result.get(1);
        Assertions.assertEquals(176.71458676442586 ,area);
        Assertions.assertEquals(47.12388980384689 ,perimeter);
    }

    @Test
    void excercise12() {
        Assertions.assertEquals(4,W3ExcercisesLVL1.Excercise12(1,4,7));

    }

    @Test
    void excercise13() {
        List<Object> result = W3ExcercisesLVL1.Excercise13(5.5,8.5);
        Double area = (Double) result.get(0);
        Double perimeter = (Double) result.get(1);
        Assertions.assertEquals(46.75 ,area);
        Assertions.assertEquals(28 ,perimeter);
    }

    @Test
    void excercise15() {

        double o1 = 7.5;
        String o2 = "Hello";
        List<Object> result = W3ExcercisesLVL1.Excercise15(o1,o2);
        Assertions.assertEquals(7.5,result.get(1));
        Assertions.assertEquals("Hello",result.get(0));


    }
}