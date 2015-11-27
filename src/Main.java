import P0_10.P1;
import P0_10.P2;
import P0_10.P3;

import java.util.Scanner;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
public class Main {
    public static void main(String[] args) {
        /* Project Euler 1*/
        System.out.println(P1.getSum(1000));
        System.out.println(P1.getSumBetter(1000));

        /* Project Euler 2*/
        System.out.println(P2.getSum(4000000));
        System.out.println(P2.getSumBetter(4000000));

         /* Project Euler 3*/
        System.out.println(P3.getLargest(600851475143L));

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
