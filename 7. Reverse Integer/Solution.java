/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
 * Memory Usage: 33.7 MB, less than 11.66% of Java online submissions for Reverse Integer.
 */
class Solution {
    public int reverse(int x) {
        long sum = 0;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        while (x > 0) {
            int rem = x % 10;
            sum = (sum* 10) + rem;
            x = x/10;
        }
        if (sum > Integer.MAX_VALUE) {
            return 0;
        }
        if (negative) {
            sum *= -1;
        }
        return (int)sum;
    }
}