package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 4=====

    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 �� 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P4 {
    /* abccba=100000*a+10000*b+1000*c+100*c+10*b+a=11(9091*a+910*b+100c)=mn
       ��m��n��һ����11�ı���������m��11�ı���������11*10<m<11*90
    */
    public static int getPalindromic() {
        int sum = 0, result = 0;
        ednd:
        for (int i = 9; i >= 1; i--)
            for (int j = 9; j >= 0; j--)
                for (int k = 9; k >= 0; k--) {
                    sum = 9091 * i + 910 * j + 100 * k;
                    for (int l = 90; l >= 10; l--) {
                        if (sum % l == 0) {
                            if (sum / l > 999) break;
                                //��Ϊl��Խ��ԽС����sum/l��Խ��Խ���������sum/l>999�ˣ������l������ִ���ˣ���˲���break������ѭ����������continue
                            else {
                                result = sum * 11; //�ҵ���
                                break ednd;
                            }
                        }
                    }
                }

        return result;
    }
}
