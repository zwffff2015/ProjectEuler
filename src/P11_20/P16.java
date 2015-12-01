package P11_20;

import java.math.BigInteger;

/**
 * Author: DarrenZeng
 * Date: 2015-12-01
 */
/*
    =====Project Euler 16=====

    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    What is the sum of the digits of the number 2^1000?
 */
public class P16 {
    public static int getSumDigits(int n, int number) {
        BigInteger i = BigInteger.valueOf(n);
        BigInteger t = i.shiftLeft(number - 1);
        BigInteger sum = BigInteger.ZERO;
        while (t.compareTo(BigInteger.valueOf(0)) != 0) {
            sum = sum.add(t.mod(BigInteger.valueOf(10)));
            t = t.divide(BigInteger.valueOf(10));
        }

        return sum.intValue();
    }

    public static long getPow(int n, int number) {
        long y = 1;
        while (true) {
            int t = number % 2;
            number = number / 2;

            if (t == 1) {
                y = y * n;
            }

            if (n == 0)
                break;

            n = n * n;
        }
        return y;
    }
}
