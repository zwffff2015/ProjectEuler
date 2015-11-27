package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 7=====

    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    What is the 10 001st prime number?
*/
public class P7 {
    public static long getSpecifiedPrime(int number) {
        int i = 0;
        int start = 2;
        while (i < number) {
            double sqrt = Math.sqrt(start);
            int j;
            for (j = 2; j <= sqrt; j++) {
                if (start % j == 0) {
                    break;
                }
            }
            if (j > sqrt) {
                i++;
                if (i == number)
                    return start;
            }
            start++;
        }
        return 0;
    }
}
