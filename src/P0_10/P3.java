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
    public static int getLargest(long number) {
        int i = 2;
        long t = number / i;
        while (i < t) {
            while (number % i != 0) {
                i++;
            }
            //System.out.printf("%1$d ", i);
            t = number / i;
            number = t;
            i++;
        }
        return i-1;
    }
}
