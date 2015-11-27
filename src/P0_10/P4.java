package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 4=====

    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P4 {
    /* abccba=100000*a+10000*b+1000*c+100*c+10*b+a=11(9091*a+910*b+100c)=mn
       则m，n有一个是11的倍数，假设m是11的倍数。则让11*10<m<11*90
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
                                //因为l是越来越小，则sum/l会越来越大，所以如果sum/l>999了，后面的l不用再执行了，因此采用break跳出本循环，而不是continue
                            else {
                                result = sum * 11; //找到了
                                break ednd;
                            }
                        }
                    }
                }

        return result;
    }
}
