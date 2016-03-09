package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 21=====

    Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10000.
 */
public class P21 {
    public static int getSumOfAmicableNumbers(int number) throws Exception {
        int sum = 0;
        int[] cache = new int[number];
        for (int i = 1; i < number; i++) {
            // 已经被计算过了，不再重复计算
            if (cache[i] == 1) continue;
            int sumOfDivisors = getSumOfDivisors(i);
            // 当d(a)=b，判断a是否等于b
            if (sumOfDivisors == i) continue;
            int otherSumOfDivisors = getSumOfDivisors(sumOfDivisors);
            if (otherSumOfDivisors == i) {
                sum += i + sumOfDivisors;
                cache[sumOfDivisors] = 1;
            }
        }
        return sum;
    }


    /*
        获取一个数除它本身之外的所有因子的和
     */
    public static int getSumOfDivisors(int number) throws Exception {
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
    public static int[] getAllDivisors(int number) throws Exception {
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
