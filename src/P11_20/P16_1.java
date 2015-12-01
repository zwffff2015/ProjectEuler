package P11_20;

/**
 * Author: DarrenZeng
 * Date: 2015-12-01
 */
/*
    =====额外有趣测试题=====

    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    What is the sum of the digits of the number 2^1000?
 */
public class P16_1 {
    /* 求N！的末尾有连续几个0
        分析：因为末尾的0，是代表一个进位，相当于乘以10，而10是由2*5所得。
        我们知道10^m=(2*5)^m=2^m*5^m，这里代表有m个0。
        所以求在N！的末尾有多少个0，则转化为最多有多少个2或者5了，因为可以被2整除的数远远多于被5整除的数，所以问题就变成了，求可以被5整除。
        公式则变成了y=N/5+N/5^2+N/5^3+...+N/5^i (1<=i<m,找到第一个m，使得5^m>N)
     */
    public static int getTotalZero(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    /* 更一般性的推广，求n！中有k的个数
        类似问题：
        1.求n!的二进制位表示中最低位1中的位置，其实相当于求质因数2的个数，即getTotalZero(n,2)

        扩展问题：
        1.1到100的阶乘的和的末位数是几？
        1!=1,2!=2,3!=6,4!=24,5!=120,从5的阶乘以后的所有数的阶乘的末尾都是0，所以1到4的阶乘会产生个位数，所以为1+2+6+24=33，所以个位数是3
     */
    public static int getTotalZero(int n,int k){
        int sum = 0;
        while (n != 0) {
            sum += n / k;
            n /= k;
        }
        return sum;
    }
}
