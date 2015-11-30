package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-11-30
 */
/*
    =====Project Euler 14=====

    The following iterative sequence is defined for the set of positive integers:

        n �� n/2 (n is even)
        n �� 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 �� 40 �� 20 �� 10 �� 5 �� 16 �� 8 �� 4 �� 2 �� 1
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
                    if (number < limit && flag[(int) number] != 0) {    //�˴����û��������
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
    �˷����Ὣ;����ÿһ���ڵ�Ĳ�������ס������Ч���Ϸ���û�б���һ�ַ������죬��Ϊ���ڴ��������飬ѭ���жϣ��Լ�ǿ��ת��������ֻ������չ˼·
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
                    if (number < limit && flag[(int) number] != 0) {    //�˴����û��������
                        totalSteps += flag[(int) number] - 1;
                        break;
                    }


                    totalSteps++;
                    if (number % 2 == 0)
                        number = number / 2;
                    else
                        number = 3 * number + 1;

                    /*����;����ÿһ���ڵ㶼���л����¼*/
                    /*
                           ��;���ڵ��ֵ���ڻ��ߵ������Ǹ�����limitʱ����Ϊ��������С��limit��������
                           ���ߵ�ǰ�ڵ���ܲ����Ѿ����������������Ҫ���㡣����Ϊ�˲�Ӱ���������Ǽ��㲽���Ĺ�ʽ����totalSteps-j-1)��
                           ���ǿ��Խ���ǰ�ڵ�λ��Ҳ��ӵ���ʱ����subFlag�У����ǲ���һ���Ƿ���ֵ������limit+1����ΪsubFlag����Ϸ���ֵ��һ��С��limit�����֣�
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
                         /*����3 => 10 => 5 => 16 => 8 => 4 => 2 => 1��
                           �����������3���ܲ�����8��ʱ������֪��10�Ĳ�����3�Ĳ���-1��
                           ��10�������0��λ�ã�����10���ܲ�����3���ܲ���-10��������λ��-1����totalSteps-j-1)��
                           �˴�����һ�����ɣ���;���ڵ��ֵ���ڻ��ߵ������Ǹ�����limitʱ����Ϊ��������С��limit��������
                           ���ߵ�ǰ�ڵ���ܲ����Ѿ����������������Ҫ���㡣����Ϊ�˲�Ӱ���������Ǽ��㲽���Ĺ�ʽ����totalSteps-j-1)��
                           ���ǿ��Խ���ǰ�ڵ�λ��Ҳ��ӵ���ʱ����subFlag�У����ǲ���һ���Ƿ���ֵ������limit+1����ΪsubFlag����Ϸ���ֵ��һ��С��limit�����֣�
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
