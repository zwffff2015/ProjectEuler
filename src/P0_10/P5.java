package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 5=====

    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class P5 {
    /*将1...N，进行遍历，然后分解公因子的方式*/
    public static long getSmallest(int number) {
        int total = 0;
        int[] temp = new int[number];
        for (int i = 2; i <= number; i++) {
            int div = i;
            for (int j = 0; j < total; j++) {
                if (div % temp[j] == 0) {
                    div = div / temp[j];
                }
            }
            if (div != 1) {
                temp[total] = div;
                total++;
            }
        }

        int result = 1;
        for (int i = 0; i < total; i++) {
            result *= temp[i];
        }
        return result;
    }
}
