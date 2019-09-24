package simplejavaapps.LifeGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeGameTest {





    @Test
    void LifeGameTest()
    {
        int[][] expected = new int[4][4];
        expected[0][1]=1;
        expected[0][2]=1;
        expected[0][3]=1;


        LifeGame lifeGame = new LifeGame(expected);
        String expectedString = lifeGame.toString();

        lifeGame.nextGeneration();
        lifeGame.nextGeneration();
        Assertions.assertEquals(expectedString,lifeGame.toString());


    }

    @Test
    void LifeGameTestNormalization()
    {
        int length = 5;
        for(int i=-1;i<length*2;i++)
        {
            System.out.println ("i="+i+" | "+(i + length) % length);
        }
    }

}