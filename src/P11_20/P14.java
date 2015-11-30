package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-11-30
 */
/*
    =====Project Euler 14=====

    The following iterative sequence is defined for the set of positive integers:

        n → n/2 (n is even)
        n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?

    NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class P14 {
    public static int getLongestChain(int limit) {
        int longestSteps = 0;
        for (int i = 1; i < limit; i++) {
            int number = i;
            int totalSteps = 1;
            while (number != 1) {
                totalSteps++;
                if (number % 2 == 0)
                    number = number / 2;
                else
                    number = 3 * number + 1;
            }
            if (totalSteps > longestSteps)
                longestSteps = totalSteps;
        }
        return longestSteps;
    }

    public static int getLongestChainBetter(int limit) throws Exception {
        int[] flag = new int[limit];
        int longestSteps = 0;
        int longestStepsNumber = 0;
        long number = 0;
        for (int i = 1; i < limit; i++) {
            try {
                number = i;
                int totalSteps = 1;
                while (number != 1) {
                    if (number < limit && flag[(int) number] != 0) {    //此处利用缓存的特性
                        totalSteps += flag[(int) number] - 1;
                        break;
                    }

                    totalSteps++;
                    if (number % 2 == 0)
                        number = number / 2;
                    else
                        number = 3 * number + 1;
                }

                flag[i] = totalSteps;
                if (totalSteps > longestSteps) {
                    longestSteps = totalSteps;
                    longestStepsNumber = i;
                }
            } catch (Exception e) {
                System.out.println(String.format("i=%1$s, number=%2$s", i, number));
                return 0;
            }
        }
        return longestStepsNumber;
    }

    /*
    此方法会将途经的每一个节点的步长都记住，但是效率上反而没有比上一种方法更快，因为存在创建大数组，循环判断，以及强制转换操作，只在于拓展思路
     */
    public static int getLongestChainBestest(int limit) throws Exception {
        int[] flag = new int[limit];
        int longestSteps = 0;
        int longestStepsNumber = 0;
        long number = 0;
        for (int i = 1; i < limit; i++) {
            try {
                number = i;
                if (number < limit && flag[(int) number] != 0) {
                    if (flag[(int) number] > longestSteps) {
                        longestSteps = flag[(int) number];
                        longestStepsNumber = i;
                    }
                    continue;
                }

                int totalSteps = 1;
                long[] subFlag = new long[limit];
                int subStep = 0;
                while (number != 1) {
                    if (number < limit && flag[(int) number] != 0) {    //此处利用缓存的特性
                        totalSteps += flag[(int) number] - 1;
                        break;
                    }


                    totalSteps++;
                    if (number % 2 == 0)
                        number = number / 2;
                    else
                        number = 3 * number + 1;

                    /*对于途经的每一个节点都进行缓存记录*/
                    /*
                           当途经节点的值大于或者等于我们给定的limit时（因为我们是找小于limit的数），
                           或者当前节点的总步数已经被计算出来，则不需要计算。但是为了不影响下面我们计算步数的公式（即totalSteps-j-1)，
                           我们可以将当前节点位置也添加到临时数组subFlag中，但是采用一个非法的值，比如limit+1（因为subFlag数组合法的值是一个小于limit的数字）
                     */
                    if (number < limit && flag[(int) number] == 0)
                        subFlag[subStep] = number;
                    else
                        subFlag[subStep] = limit + 1;

                    subStep++;
                }

                int j = 0;
                while (subFlag[j] != 0) {
                    if (subFlag[j] < limit) {
                        int index = (int) subFlag[j];
                         /*比如3 => 10 => 5 => 16 => 8 => 4 => 2 => 1，
                           当我们算出来3的总步数是8的时候，我们知道10的步数是3的步数-1，
                           而10在数组的0号位置，所以10的总步数是3的总步数-10所在数组位置-1（即totalSteps-j-1)，
                           此处还有一个技巧，当途经节点的值大于或者等于我们给定的limit时（因为我们是找小于limit的数），
                           或者当前节点的总步数已经被计算出来，则不需要计算。但是为了不影响下面我们计算步数的公式（即totalSteps-j-1)，
                           我们可以将当前节点位置也添加到临时数组subFlag中，但是采用一个非法的值，比如limit+1（因为subFlag数组合法的值是一个小于limit的数字）
                          */
                        flag[index] = totalSteps - j - 1;
                        System.out.printf("i=%1$d,totalSteps=%2$d\r\n", index, flag[index]);
                    }
                    j++;
                }

                flag[i] = totalSteps;
                System.out.printf("i=%1$d,totalSteps=%2$d\r\n", i, totalSteps);
                if (totalSteps > longestSteps) {
                    longestSteps = totalSteps;
                    longestStepsNumber = i;
                }
            } catch (Exception e) {
                System.out.println(String.format("i=%1$s, number=%2$s", i, number));
                return 0;
            }
        }
        return longestStepsNumber;
    }
}
