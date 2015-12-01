package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 3=====

    The prime factors of 13195 are 5, 7, 13
	and 29. What is the largest prime factor of the number 600851475143 ?
 */
public class P3 {
    /*
        假设求n的所有因子，我们知道一个数的因子一定是成对出现的，比如n=a*b,则a，b都是n的因子。
        再假设从2...n-1进行遍历（因为任何数都可以被1和它本身整除，所以1和n不考虑），求n的所有因子，但是当出现一个因子a1(a1是2...a1之间唯一能整除n的数）的时候，我们遍历的最大数就不再是n了，而会变成是n/a1，
        也就是说下一个因子a2一定满足a1<a2<n/a1。a2>a1显而易见，我们来证明a2<n/a1,假设n=a2*b2;即a1*b1=a2*b2;因为a1<a2,则b2<b1=n/a1
     */
    public static int getLargest(long number) {
        int i = 2;
        long t = number / i;
        int largestPrime = 2;
        while (i < t) {
            while (number % i != 0) {
                i++;
            }

            if (IsPrime(i)) {
                if (i > largestPrime)
                    largestPrime = i;
            }

            t = number / i;
            number = t;
            i++;
        }
        return largestPrime;
    }

    private static boolean IsPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
