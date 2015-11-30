package P11_20;

import java.math.BigInteger;

/**
 * Author: DarrenZeng
 * Date: 2015-11-30
 */
/*
    =====Project Euler 15=====

    Starting in the top left corner of a 2��2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
    How many such routes are there through a 20��20 grid?
 */
public class P15 {
    /*
        �˴���Ҫ�����������ʽ����(0,0)�㵽��n,n)�㣬�ܹ�Ҫ��2n�����������£����Ҹ�n����
        ���������ת��������2n��������ȡn�������ƶ�������n���������ƶ���Ҳ����C(2n,n)=(2n)!/(n!*(2n-n)!) (�˴�Ϊ�������ʽ��
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
