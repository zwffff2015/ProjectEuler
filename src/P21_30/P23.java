package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 23=====

    A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

    A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

    As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

    Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class P23 {
    public static long getSum() {
        int[] abundantNumbers = new int[28123];     //存放所有的abundant number
        int[] twoAbundantsNumbers = new int[28124];   //标记所有可以用两个abundant number之和表示的数字

        int k = 0;
        for (int i = 1; i <= 28123; i++) {
            int sumOfDivisors = getSumOfDivisors(i);
            if (sumOfDivisors > i) {
                //abundant number
                for (int j = 0; j < abundantNumbers.length; j++) {
                    if (abundantNumbers[j] == 0) break;
                    if (i + abundantNumbers[j] <= 28123)
                        twoAbundantsNumbers[i + abundantNumbers[j]] = 1;
                }

                if (2 * i <= 28123)
                    twoAbundantsNumbers[2 * i] = 1;
                abundantNumbers[k++] = i;
            }
        }

        long sum = 0;
        for (int i = 1; i <= 28123; i++) {
            if (twoAbundantsNumbers[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /*
        获取一个数除它本身之外的所有因子的和
     */
    public static int getSumOfDivisors(int number) {
        int[] divisors = getAllDivisors(number);
        int sum = 0;
        for (int divisor : divisors) {
            if (divisor != number)
                sum += divisor;
        }
        return sum;
    }

    /*
        获取一个数的所有因子
     */
    public static int[] getAllDivisors(int number) {
        int[] result = new int[(number / 2) + 1];
        try {
            int endIndex = number;
            int j = 0;
            for (int i = 1; i < endIndex; i++) {
                if (number % i == 0) {
                    result[j++] = i;
                    if (number / i != i)
                        result[j++] = number / i;
                    endIndex = number / i;
                }
            }
        } catch (Exception e) {
            System.out.println("number:" + number);
        }
        return result;
    }
}
