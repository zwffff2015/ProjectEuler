package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 24=====

    A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

    012   021   102   120   201   210

    What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class P24 {
    /* 查找从小到大全排列中指定数字 */
    public static String getSpecifiedNumber(int position) {
        int[] factorial = new int[10];
        int mul = 1;
        for (int i = 1; i < 10; i++) {
            mul *= i;
            factorial[i] = mul;
        }

        position--;
        int[] times = new int[9];
        for (int i = 9; i >= 1; i--) {
            times[9 - i] = position / factorial[i];
            position -= times[9 - i] * factorial[i];
        }

        int[] outResult = new int[10];
        for (int i = 0; i < outResult.length; i++) {
            outResult[i] = i;
        }

        for (int i = 0; i < times.length; i++) {
            int temp = outResult[i + times[i]];
            for (int j = i + times[i]; j > i; j--) {
                outResult[j] = outResult[j - 1];
            }
            outResult[i] = temp;

            /*for (int j = 0; j < outResult.length; j++) {
                System.out.print(outResult[j]);
            }
            System.out.println();*/
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outResult.length; i++) {
            sb.append(outResult[i]);
        }
        return sb.toString();
    }
}
