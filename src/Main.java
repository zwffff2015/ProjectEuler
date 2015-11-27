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
        System.out.println(P3.getLargest(600851475143L));

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
        long startTime = System.currentTimeMillis();
        System.out.println(P11.getGreatestProduct(7));
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        System.out.println(Float.toString(seconds) + "s");

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
