package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 3=====

    The prime factors of 13195 are 5, 7, 13
	and 29. What is the largest prime factor of the number 600851475143 ?
 */
public class P3 {
    /*
        ������n���������ӣ�����֪��һ����������һ���ǳɶԳ��ֵģ�����n=a*b,��a��b����n�����ӡ�
        �ټ����2...n-1���б�������Ϊ�κ��������Ա�1������������������1��n�����ǣ�����n���������ӣ����ǵ�����һ������a1(a1��2...a1֮��Ψһ������n��������ʱ�����Ǳ�����������Ͳ�����n�ˣ���������n/a1��
        Ҳ����˵��һ������a2һ������a1<a2<n/a1��a2>a1�Զ��׼���������֤��a2<n/a1,����n=a2*b2;��a1*b1=a2*b2;��Ϊa1<a2,��b2<b1=n/a1
     */
    public static int getLargest(long number) {
        int i = 2;
        long t = number / i;
        int largestPrime = 2;
        while (i < t) {
            while (number % i != 0) {
                i++;
            }

            if (IsPrime(i)) {
                if (i > largestPrime)
                    largestPrime = i;
            }

            t = number / i;
            number = t;
            i++;
        }
        return largestPrime;
    }

    private static boolean IsPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
