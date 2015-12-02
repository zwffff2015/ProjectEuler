import P0_10.*;
import P11_20.*;

import java.util.Scanner;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /* Project Euler 1*/
        System.out.println(P1.getSum(1000));
        System.out.println(P1.getSumBetter(1000));

        /* Project Euler 2*/
        System.out.println(P2.getSum(4000000));
        System.out.println(P2.getSumBetter(4000000));

        /* Project Euler 3*/
        System.out.println(P3.getLargest(500));

        /* Project Euler 4*/
        System.out.println(P4.getPalindromic());

        /* Project Euler 5*/
        System.out.println(P5.getSmallest(20));

        /* Project Euler 6*/
        System.out.println(P6.getDifference(100));

        /* Project Euler 7*/
        System.out.println(P7.getSpecifiedPrime(10001));

        /* Project Euler 8*/
        System.out.println(P8.getGreatestProduct(13));

        /* Project Euler 9*/
        System.out.println(P9.getPythagoreanTriplet());
        System.out.println(P9.getPythagoreanTripletBetter());

        /* Project Euler 10*/
        System.out.println(P10.getPrimesSum(2000000));

        /* Project Euler 11*/
        System.out.println(P11.getGreatestProduct(7));

        /* Project Euler 12*/
        long startTime = System.currentTimeMillis();
        System.out.println(P12.getFirstTriangleNumber(500));
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        System.out.println(Float.toString(seconds) + "s");

        /* Project Euler 13*/
        System.out.println(P13.get10HighBit());

        /* Project Euler 14*/
        System.out.println(P14.getLongestChainBetter(1000000));

        /* Project Euler 15*/
        System.out.println(P15.getTotalRoutes(20));

        /* Project Euler 16*/
        System.out.println(P16.getSumDigits(2, 1000));
        System.out.println(P16.getPow(2, 10));

        /* Project Euler 17*/
        System.out.println(P17.getTotalLetters(1, 1000));
        System.out.println(P17.getEnglish(1000000000));
        System.out.println(P17.getEnglish(1000000));
        System.out.println(P17.getEnglish(1000));
        System.out.println(P17.getEnglish(100));
        System.out.println(P17.getEnglish(999));
        System.out.println(P17.getEnglish(85));
        System.out.println(P17.getEnglish(8354));
        System.out.println(P17.getEnglish(16250064));
        System.out.println(P17.getEnglish(1237166234));
        System.out.println(P17.getEnglish("125605445345265344524562442543252443"));

        /* Project Euler 18*/
        System.out.println(P18.getTotalSum());

        /* Project Euler 19*/
        System.out.println(P19.getTotalSundaysFellOnFirstOfMonth(1901, 2000, 0));

        /* Project Euler 20*/
        System.out.println(P20.getTotalDigits(100));

        /* 求N!末尾有几个0 */
        System.out.println(P16_1.getTotalZero(100));
        System.out.println(P16_1.getTotalZero(2, 2));
        System.out.println(P16_1.getTotalZero(3, 2));
        System.out.println(P16_1.getTotalZero(4, 2));
        System.out.println(P16_1.getTotalZero(4, 8));

        Scanner in = new Scanner(System.in);
        System.out.println("Please input a number:");
        int n = in.nextInt();

        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = i + 1;
        }

        int[] randNumbers = new int[n];
        int k = n;
        for (int i = 0; i < k; i++) {
            int index = (int) (Math.random() * n);
            randNumbers[i] = source[index];
            if (index != n - 1)
                source[index] = source[n - 1];
            n--;
        }

        for (int i = 0; i < randNumbers.length; i++) {
            System.out.printf("%1$d ", randNumbers[i]);
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }


}
