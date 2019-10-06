package simplejavaapps.Lottery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void getWinners() {
        CSVdeserializer csVdeserializer = new CSVdeserializer();
        Lottery lottery = new Lottery(csVdeserializer.deserializeData(csVdeserializer.getFileStringData()));
        lottery.displayChances();
        LotteryEntry[] winners = lottery.getWinners(10000);

        int wins = 0;

        for(int i=1;i<21;i++)
        {
            for(LotteryEntry le:winners)
            {
                if(le.getUserName().matches("\"imie"+String.format("%02d",i)+"\""))
                {
                    wins++;
                }
            }
            System.out.println("imie"+String.format("%02d",i)+" occurs "+wins+"times");
            wins = 0;
        }

    }
}