package P0_10;

/**
 * Author: DarrenZeng
 * Date: 2015-11-27
 */
/*
    =====Project Euler 9=====

    A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

                        a2 + b2 = c2

    For example, 32 + 42 = 9 + 16 = 25 = 52.

    There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    Find the product abc.
 */
public class P9 {

    /*
        Method 1 Because a^2+b^2=c^2 So let a=2mn,b=m^2-n^2,c=m^2+n^2

        As a+b+c=1000 Then 2mn+m^2-n^2+m^2+n^2=1000 => 2mn+2m^2=1000
        =>mn+m^2=500 =>m(m+n)=500

        And m>n, and n>0, so m+n>m; now we know 25*25=625>500, so m<25,n<25
    */
    public static long getPythagoreanTripletBetter() {
        int n;
        for (int m = 24; m >= 1; m--) {
            if ((500 - m * m) % m == 0) {
                n = (500 - m * m) / m;
                if (n >= m) break;
                else {
                    //System.out.printf("m=%d,n=%d,a=%d,b=%d,c=%d\r\n", m, n, 2 * m * n, m * m - n * n, m * m + n * n);
                    return 2 * m * n * (m * m - n * n) * (m * m + n * n);
                }
            }
        }
        return 0;
    }

    /*
        i^2+j^2=k^2
        (i+j+k)^2=1000^2
    */
    public static long getPythagoreanTriplet() {
        for (int i = 1; i < 1000; i++) {
            for (int j = i; j < 1000 - i; j++) {
                int k = 1000 - i - j;
                if (i * j + 1000 * k == 500000) {
                    return i * j * k;
                }
            }
        }
        return 0;
    }
}
