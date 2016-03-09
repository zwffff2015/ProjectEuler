package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-04
 */
/*
    =====Project Euler 28=====

    Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

                                    (21) 22 23 24 (25)
                                    20  (7)  8 (9) 10
                                    19  6  (1)  2 11
                                    18  (5)  4 (3) 12
                                    (17) 16 15 14 (13)

    It can be verified that the sum of the numbers on the diagonals is 101.

    What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class P28 {
    public static int getSum(int number) {
        int[][] datas = new int[number][number];
        int totalNumbers = number * number;
        int i = number / 2, j = number / 2;
        int currentDirection = 0;

        datas[i][j] = 1;
        for (int k = 2; k <= totalNumbers; k++) {
            switch (currentDirection) {
                case 0: //往右
                    datas[i][++j] = k;
                    break;
                case 1: //往下
                    datas[++i][j] = k;
                    break;
                case 2: //往左
                    datas[i][--j] = k;
                    break;
                case 3: //往上
                    datas[--i][j] = k;
                    break;
            }

            int nextCurrentDirection = (currentDirection + 1) % 4;
            currentDirection = hasValue(nextCurrentDirection, i, j, datas) ? currentDirection : nextCurrentDirection;
        }

        int sum = 0;
        for (int k = 0; k < number; k++) {
            sum += datas[k][k] + datas[k][number - k - 1];
        }
        sum -= datas[number / 2][number / 2];
        return sum;
    }

    /*
        当为n时，四个角的数字分别为n^2,n^2-n+1,n^2-2n+2,n^2-3n+3。则四个角的总和为4*n^2-6*n+6，则需要循环从3到1001即可，每次步长为2
     */
    public static int getSumBetter(int number) {
        int sum = 1;
        for (int i = 3; i <= number; i = i + 2) {
            sum += 4 * i * i - 6 * i + 6;
        }
        return sum;
    }

    private static Boolean hasValue(int direction, int i, int j, int[][] datas) {
        switch (direction) {
            case 0:
                return datas[i][j + 1] != 0;
            case 1:
                return datas[++i][j] != 0;
            case 2:
                return datas[i][--j] != 0;
            case 3:
                return datas[--i][j] != 0;
        }
        return false;
    }
}
