/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
 * Memory Usage: 36.8 MB, less than 5.88% of Java online submissions for Pow(x, n).
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N *= -1;
        }
        return helper(x,N);
    }

    public double helper(double x, long n) {
        if (n == 0)
            return 1.0;
        double d = helper(x, n / 2);
        if (n % 2 == 0) {
            return d * d;
        } else  {
            return d * d * x;
        }
    }
}