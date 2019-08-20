package com.company;

import java.util.GregorianCalendar;
import java.util.Scanner;

/*
calculation of least common multiple
testing different methods speed
 */

public class Main {


    public static void main(String[] args) {


        int[][] array = {{2,5},{5,2},{7,3},{3,7},{144,57},{57,144},{1500,5},{5,1500}};

        System.out.println("Time of calculation for each method");
        for (int[] i:array) {
            System.out.println("----------------- X:"+i[0]+" / Y:"+i[1]+" -----------------");
            System.out.println("PASS1 M1:"+String.format("%5d",getNWW_M1(i[0],i[1]))+" M2:"+String.format("%5d",getNWW_M2(i[0],i[1]))+" M3:"+String.format("%5d",getNWW_M3(i[0],i[1])));
            System.out.println("PASS2 M1:"+String.format("%5d",getNWW_M1(i[0],i[1]))+" M2:"+String.format("%5d",getNWW_M2(i[0],i[1]))+" M3:"+String.format("%5d",getNWW_M3(i[0],i[1])));
            System.out.println("PASS3 M1:"+String.format("%5d",getNWW_M1(i[0],i[1]))+" M2:"+String.format("%5d",getNWW_M2(i[0],i[1]))+" M3:"+String.format("%5d",getNWW_M3(i[0],i[1])));

        }
    }

    private static long getNWW_M1(int x, int y)
    {
        //start from lesser value, adds it and check if it is dividable by both values

        long startTime = System.nanoTime();

        int gt = x>y ? x : y;
        int ls = x>y ? y : x;
        int m = ls*gt;
        for(int i=ls;i<=m;i+=ls) {

            boolean result = i%x==0 && i%y==0;

            if(result==true)
            {
                //System.out.println("NWW: "+i);
                break;
            }
        }
        return (System.nanoTime()-startTime);
    }

    private static long getNWW_M2(int x,int y)
    {
        //start with multiplication greater value i-times and check if it is dividable by lesser value

        long startTime = System.nanoTime();
        int gt = x>y ? x : y;
        int ls = x>y ? y : x;
        for(int i=1;i<=gt;i++) {

            boolean result = ((i*gt)%ls==0);

            if(result==true)
            {
                //System.out.println("NWW: "+i*gt);
                break;
            }
        }
        return (System.nanoTime()-startTime);
    }

    private static long getNWW_M3(int x,int y)
    {
        //start with multiplication lesser value i-times and check if it is dividable by greater value

        long startTime = System.nanoTime();
        int gt = x>y ? x : y;
        int ls = x>y ? y : x;

        for(int i=1;i<=gt;i++) {

            boolean result = ((i*ls)%gt==0);

            if(result==true)
            {
                //System.out.println("NWW: "+i*ls);
                break;
            }
        }
        return (System.nanoTime()-startTime);
    }
}
