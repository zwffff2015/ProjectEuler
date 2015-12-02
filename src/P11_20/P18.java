package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-12-02
 */
/*
    =====Project Euler 18=====

    By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

                                            3
                                           7 4
                                          2 4 6
                                         8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.
Find the maximum total from top to bottom of the triangle below:

                                                75
                                               95 64
                                              17 47 82
                                             18 35 87 10
                                            20 04 82 47 65
                                           19 01 23 75 03 34
                                          88 02 77 73 07 63 67
                                         99 65 04 28 06 16 70 92
                                        41 41 26 56 83 40 80 70 33
                                       41 48 72 33 47 32 37 16 94 29
                                      53 71 44 65 25 43 91 52 97 51 14
                                     70 11 33 28 77 73 17 78 39 68 17 57
                                    91 71 52 38 17 14 91 43 58 50 27 29 48
                                   63 66 04 68 89 53 67 30 73 16 69 87 40 31
                                  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class P18 {
    /*private static final int[][] datas = new int[][]{
            {3},
            {6, 7},
            {2, 4, 4, 6},
            {6, 5, 7, 8, 3},
    };*/
    private static final int[][] datas = new int[][]{
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
    };
    private static int currentSum = 0;

    /*
        采用从下往上的方式，把下一行与上一行元素相邻的两个元素与之相加，将更大的结果，存放在该元素所在位置
     */
    public static int getTotalSum() {
        for (int i = datas.length - 1; i > 0; i--) {
            for (int j = datas[i].length - 1; j > 0; j--) {
                datas[i - 1][j - 1] += datas[i][j] > datas[i][j - 1] ? datas[i][j] : datas[i][j - 1];
            }
        }
        return datas[0][0];
    }

    /*
        此处利用回溯方法，从上往下匹配。只匹配a[i][j]与a[i+1][j-1],a[i+1][j]以及a[i+1][j+1]之间和的大小。不符合本题目意思
     */
    public static void getTotalSum1(int sum, int i, int j) {
        if (i == datas.length - 1) {
            if (sum > currentSum) {
                currentSum = sum;
            }
        } else {
            int left = (j - 1 >= 0 && j - 1 < datas[i + 1].length) ? datas[i + 1][j - 1] : 0;
            int below = (j >= 0 && j < datas[i + 1].length) ? datas[i + 1][j] : 0;
            int right = (j + 1 >= 0 && j + 1 < datas[i + 1].length) ? datas[i + 1][j + 1] : 0;
            if (left > below) {
                if (left > right) {
                    getTotalSum1(sum + left, i + 1, j - 1);
                } else if (left < right) {
                    getTotalSum1(sum + right, i + 1, j + 1);
                } else {
                    getTotalSum1(sum + left, i + 1, j - 1);
                    getTotalSum1(sum + right, i + 1, j + 1);
                }
            } else if (left < below) {
                if (below > right) {
                    getTotalSum1(sum + below, i + 1, j);
                } else if (below < right) {
                    getTotalSum1(sum + right, i + 1, j + 1);
                } else {
                    getTotalSum1(sum + below, i + 1, j);
                    getTotalSum1(sum + right, i + 1, j + 1);
                }
            } else {
                if (left < right) {
                    getTotalSum1(sum + right, i + 1, j + 1);
                } else if (left > right) {
                    getTotalSum1(sum + left, i + 1, j - 1);
                    getTotalSum1(sum + below, i + 1, j);
                } else {
                    getTotalSum1(sum + left, i + 1, j - 1);
                    getTotalSum1(sum + below, i + 1, j);
                    getTotalSum1(sum + right, i + 1, j + 1);
                }
            }
        }
    }

    /*
        此处利用回溯方法，从上往下匹配。只匹配a[i][j]与a[i+1][j]以及a[i+1][j+1]之间和的大小。不符合本题目意思
     */
    public static void getTotalSum2(int sum, int i, int j) {
        if (i == datas.length - 1) {
            if (sum > currentSum) {
                currentSum = sum;
            }
        } else {
            int below = (j >= 0 && j < datas[i + 1].length) ? datas[i + 1][j] : 0;
            int right = (j + 1 >= 0 && j + 1 < datas[i + 1].length) ? datas[i + 1][j + 1] : 0;
            if (below < right) {
                getTotalSum2(sum + right, i + 1, j + 1);
            } else if (below > right) {
                getTotalSum2(sum + below, i + 1, j);
            } else {
                getTotalSum2(sum + below, i + 1, j);
                getTotalSum2(sum + below, i + 1, j + 1);
            }
        }
    }
}
