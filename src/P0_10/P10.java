package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 10=====

    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
 */
public class P10 {
    public static long getPrimesSum(int number) {
        long sum = 0;
        for (int i = 2; i < number; i++) {
            if (IsPrime(i)) sum += i;
        }
        return sum;
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
