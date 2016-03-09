package P21_30;

/**
 * Author: DarrenZeng
 * Date: 2015-12-03
 */
/*
    =====Project Euler 25=====

    The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn?1 + Fn?2, where F1 = 1 and F2 = 1.
    Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144
    The 12th term, F12, is the first term to contain three digits.

    What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class P25 {
    public static int getIndex(int totalDigits) {
        int[] number1 = new int[totalDigits];
        int[] number2 = new int[totalDigits];
        number1[0] = 1;
        number2[0] = 1;

        int i = 3;
        int currentPosition = 0;  //记录结果位置，用于判断相加的时候，是否结束。
        int j;
        while (true) {
            int carryBit = 0;
            if (i % 2 == 0) {
                for (j = 0; j < totalDigits; j++) {
                    int tempResult = number1[j] + number2[j] + carryBit;
                    number2[j] = tempResult % 10;
                    carryBit = tempResult / 10;
                    if (carryBit == 0 && number1[j] == 0 && number2[j] == 0 && j >= currentPosition) {
                        currentPosition = j;
                        break;
                    }
                }
            } else {
                for (j = 0; j < totalDigits; j++) {
                    int tempResult = number1[j] + number2[j] + carryBit;
                    number1[j] = tempResult % 10;
                    carryBit = tempResult / 10;
                    if (carryBit == 0 && number1[j] == 0 && number2[j] == 0 && j >= currentPosition) {
                        currentPosition = j;
                        break;
                    }
                }
            }

            if (j >= totalDigits) {
                break;
            }
            i++;
        }
        return i;
    }
}
