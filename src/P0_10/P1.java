package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 1=====

    10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
	these multiples is 23. Find the sum of all the multiples of 3 or 5
	below 1000.
 */
public class P1 {
    public static long getSum(int number) {
        long sum = 0;
        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /*此处利用了求和公式偶数*/
    public static long getSumBetter(int number){
        /* (1+2+...+333)*3+(1+2+...+199)*5-(1+2+..+66)*15 */
        int num = number - 1;
        return  ((num / 3) * (num / 3 + 1) * 3) / 2 + ((num / 5) * (num / 5 + 1) * 5) / 2 - ((num / 15) * (num / 15 + 1) * 15 / 2);
    }


}
