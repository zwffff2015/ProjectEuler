package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 6=====

    The sum of the squares of the first ten natural numbers is,

    1^2 + 2^2 + ... + 10^2 = 385
    The square of the sum of the first ten natural numbers is,

    (1 + 2 + ... + 10)2 = 55^2 = 3025
    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 ? 385 = 2640.

    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class P6 {
    /*The sum of the squares of the first n natural numbers is n*(n+1)*(2*n+1)/6
      The square of the sum of the first n natural numbers is (n*(n+1)/2)*(n*(n+1)/2), because the sum of the first n natural numbers is n*(n+1)/2
    */
    public static long getDifference(int number) {
        long sumSquares = number * (number + 1) * (2 * number + 1) / 6;
        long squareSum = (number * (number + 1) / 2) * (number * (number + 1) / 2);
        return squareSum - sumSquares;
    }
}
