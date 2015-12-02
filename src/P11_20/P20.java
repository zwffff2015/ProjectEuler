package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-12-02
 */
/*
    =====Project Euler 20=====

    n! means n × (n ? 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
 */
public class P20 {
    public static int getTotalDigits(int number) {
        int[] result = new int[number * 2];     //保存结果数据
        result[0] = 1;

        int temp = 0;       //结果数据的最后位置
        for (int i = 2; i <= number; i++) {
            int carryBit = 0;
            for (int j = 0; j < result.length; j++) {
                int tempResult = result[j] * i + carryBit;
                result[j] = tempResult % 10;
                carryBit = tempResult / 10;
                if (carryBit == 0 && result[j + 1] == 0 && j >= temp) {
                    temp = j;
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return sum;
    }
}
