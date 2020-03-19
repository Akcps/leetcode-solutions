/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
 * Memory Usage: 36.7 MB, less than 5.00% of Java online submissions for Sqrt(x).
 */
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int mid, low = 2, high = x / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            num = (long)mid * mid;
            if (num > x) {
                high = mid - 1;
            }
            else if (num < x) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return high;
    }
}