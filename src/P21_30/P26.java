package P21_30;

import java.math.BigInteger;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 26=====

    A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

        1/2	= 	0.5
        1/3	= 	0.(3)
        1/4	= 	0.25
        1/5	= 	0.2
        1/6	= 	0.1(6)
        1/7	= 	0.(142857)
        1/8	= 	0.125
        1/9	= 	0.(1)
        1/10	= 	0.1
    Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

    Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class P26 {
    public static int getLongestRecurringCycle(int number) {
        int max = 0;
        int res = 0;
        for (int i = 2; i < number; i++) {
            if (i % 2 != 0 && i % 5 != 0) {
                int c = getRecurringCycleNumber(BigInteger.valueOf(i));
                if (c > max) {
                    max = c;
                    res = i;
                }
            }
        }
        return res;
    }

    /*
    This method is better.
     */
    public static int getLongestRecurringCycleBetter(int number) {
        int max = 0;
        int currentPosition = 0;
        for (int i = 2; i < number; i++) {
            int recurringCycleLength = getRecurringCycleLength(1, i);
            if (recurringCycleLength > max) {
                max = recurringCycleLength;
                currentPosition = i;
            }
        }
        return currentPosition;
    }

    private static int getRecurringCycleNumber(BigInteger n) {
        BigInteger k = BigInteger.valueOf(10);
        BigInteger c = BigInteger.ONE;
        while (k.subtract(BigInteger.ONE).mod(n).compareTo(BigInteger.ZERO) != 0) {
            k = k.multiply(BigInteger.valueOf(10));
            c = c.add(BigInteger.ONE);
        }
        return c.intValue();
    }

    /*
        将两个数相除的结果转化成小数，循环位用小括号括起来
        比如
            1/2 = 0.5
            1/3 = 0.(3)
            1/4 = 0.25
            1/5 = 0.2
            1/6 = 0.1(6)
            1/7 = 0.(142857)
            ...
     */
    public static String getDecimal(int numberator, int denominator) {
        int[] remainderCache = new int[1000];
        int[] decimal = new int[1000];

        int i = 0;
        int j = 0;
        int cyclePosition = -1; //循环节所在数字起始位置
        while (true) {
            int remainder = numberator % denominator;
            if (remainder == 0) {
                decimal[i++] = numberator / denominator;
                break;
            } else {
                decimal[i++] = numberator / denominator;

                boolean isCycle = false;
                for (int k = 0; k < remainderCache.length; k++) {
                    if (remainderCache[k] == 0)
                        break;
                    if (remainder == remainderCache[k]) {
                        cyclePosition = k;
                        isCycle = true;   //说明找到循环节所在数字了
                        break;
                    }
                }

                if (isCycle) break;

                remainderCache[j++] = remainder;
                numberator = remainder * 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cyclePosition != -1) {
            for (int k = 0; k < i; k++) {
                if (cyclePosition + 1 == k) {
                    sb.append("(");
                }
                sb.append(decimal[k]);
                if (k == 0) {
                    sb.append(".");
                }
                if (k == i - 1) {
                    sb.append(")");
                }
            }
        } else {
            for (int k = 0; k < i; k++) {
                sb.append(decimal[k]);
                if (k == 0) {
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }

    /*
    采用将余数缓存起来的方式，每次产生的余数，都和已缓存的余数比较，如果相等，则该余数为循环起始数，当前缓存的位置为循环起始位置。
     */
    public static int getRecurringCycleLength(int numberator, int denominator) {
        int[] remainderCache = new int[1000];
        int[] decimal = new int[1000];

        int i = 0;
        int j = 0;
        while (true) {
            int remainder = numberator % denominator;
            if (remainder == 0) {
                decimal[i++] = numberator / denominator;
                break;
            } else {
                decimal[i++] = numberator / denominator;

                for (int k = 0; k < remainderCache.length; k++) {
                    if (remainderCache[k] == 0)
                        break;
                    if (remainder == remainderCache[k]) {
                        return j - k;
                    }
                }

                remainderCache[j++] = remainder;
                numberator = remainder * 10;
            }
        }
        return 0;
    }
}
