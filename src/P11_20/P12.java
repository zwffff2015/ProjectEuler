package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-11-30
 */
/*
    =====Project Euler 12=====

    The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

                                    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

    Let us list the factors of the first seven triangle numbers:

             1: 1
             3: 1,3
             6: 1,2,3,6
            10: 1,2,5,10
            15: 1,3,5,15
            21: 1,3,7,21
            28: 1,2,4,7,14,28
    We can see that 28 is the first triangle number to have over five divisors.

    What is the value of the first triangle number to have over five hundred divisors?
 */
public class P12 {
    /* 这里我们考虑，一个数的因子一定是成对出现的，比如t=n*m;那t的因子肯定包含n和m。
        那我们再考虑的是假如有n1<n2, t=n1*m1， t=n2*m2，则m2<m1。所以我们可以利用这个特性，不断缩小循环的范围。
     */
    public static long getFirstTriangleNumber(int number) {
        long n = 1;
        while (true) {
            long sum = n * (n + 1) / 2;
            long endIndex = sum;
            int totalDivisors = 0;
            for (int i = 1; i < endIndex; i++) {
                if (sum % i == 0) {
                    totalDivisors += 2;
                    endIndex = sum / i;
                }
            }

            if (totalDivisors > number)  //Find it
                break;
            n++;
        }
        return n * (n + 1) / 2;
    }
}
