package P11_20;

import java.math.BigInteger;

/**
 * Author: DarrenZeng
 * Date: 2015-11-30
 */
/*
    =====Project Euler 15=====

    Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
    How many such routes are there through a 20×20 grid?
 */
public class P15 {
    /*
        此处主要利用组合数公式，从(0,0)点到（n,n)点，总共要走2n步，并且向下，向右各n步，
        所以问题就转换成了在2n步中随意取n步向下移动，其余n步则向右移动。也就是C(2n,n)=(2n)!/(n!*(2n-n)!) (此处为组合数公式）
     */
    public static BigInteger getTotalRoutes(int gridNumber) {
        /*BigInteger item = BigInteger.valueOf(1);
        for (int i = gridNumber * 2; i > gridNumber; i--) {
            item = item.multiply(BigInteger.valueOf(i));
        }

        BigInteger item1 = getFactorial(gridNumber);
        return item.divide(item1);*/

        return getFactorial(gridNumber * 2).divide(getFactorial(gridNumber).multiply(getFactorial(gridNumber)));
    }

    private static BigInteger getFactorial(int number) {
        if (number == 1)
            return BigInteger.valueOf(1);
        return getFactorial(number - 1).multiply(BigInteger.valueOf(number));
    }
}
