package simplejavaapps.Lottery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lottery {
/*
pick winners of the lottery from users entries
if an user introduce another user he gets more chance to win
one user can win miltiple awards
 */

    private LotteryEntry[] entries = null;
    private int chanceSum = 0;

    public Lottery(LotteryEntry[] entries)
    {
        this.entries = entries;

        for(LotteryEntry le:entries) {
            calculateChance(le);
            chanceSum = chanceSum+le.getChance();
        }
    }

    public LotteryEntry[] getWinners(int numberOfWinners)
    {

        LotteryEntry[] winners = new LotteryEntry[numberOfWinners = numberOfWinners<0?0:numberOfWinners];


        ArrayList<LotteryEntry> list = new ArrayList();

        for(LotteryEntry le:entries)
        {
            for(int i=0;i<=le.getChance();i++)
            {
                list.add(le);
            }
        }
        Collections.shuffle(list);

        for(int i=0;i<numberOfWinners;i++)
        {
            winners[i] = list.get(getRandomNumberFromRange(0,list.size()-1));

        }

        return winners;
    }

    private void calculateChance(LotteryEntry le) {
        int chance = le.getChance();
        for(LotteryEntry e:this.entries)
        {
            if(e.getIntroductor().equalsIgnoreCase(le.getUserName()) & e.getUserName()!=le.getUserName())
            {
                chance++;
            }

        }
        le.setChance(chance);
    }


    private int getRandomNumberFromRange(int min, int max)
    {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }

        int negativeVal1 = (min < 0) ? 1 : 0;
        int negativeVal2 = (min < 0 & max > 0) ? 1 : 0;


            double x = ((Math.random() * ((max - min) + 1 + negativeVal2)) + min - negativeVal1);
            return (int) x;

    }

    public void displayWinners(LotteryEntry[] winnersList)
    {
        for(LotteryEntry le:winnersList)
        {
            System.out.println("winner: "+le.getUserName());
        }
    }

    public void displayChances()
    {
        for(LotteryEntry le:entries)
        {
            System.out.println(le.getUserName()+" ch: "+le.getChance());
        }
    }
}
