package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-07
 */
/*
    =====Project Euler 27=====

    Euler discovered the remarkable quadratic formula:

n? + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41? + 41 + 41 is clearly divisible by 41.

The incredible formula  n? ? 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, ?79 and 1601, is ?126479.

Considering quadratics of the form:

n? + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |?4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 */
public class P27 {
    /*
        当n=0时，n^2+a*n+b=b必须为质数，则b必须为质数
        当n=1时，n^2+a*n+b=1+a+b必须为质数，则a>-b-1
     */
    public static int getProduct() {
        int max = 0;
        int result = 0;
        for (int b = 2; b < 1000; b++) {
            if (b % 2 == 0 || b % 5 == 0) continue;
            for (int a = -b; a < 1000; a++) {
                int n = 0;

                int data = n * n + a * n + b;
                while (data > 0 && isPrime(data)) {
                    n++;
                    data = n * n + a * n + b;
                }

                if (n > max) {
                    max = n;
                    result = a * b;
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
