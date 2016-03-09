/**
 * Author: DarrenZeng
 * Date: 2016-03-03
 */
public class p {
    public int GetMaxSum(int[] a, int n) {
        if (a == null || n <= 0) {
            return 0;
        }

        int maxSum = -999999;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            if (currSum <= 0)
            {
                currSum = a[i];
            }
            else
            {
                currSum += a[i];
            }

            if (currSum > maxSum)
                maxSum = currSum;
        }

        return maxSum;
    }

}
