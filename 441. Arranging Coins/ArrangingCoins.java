/**
 * Runtime: 8 ms, faster than 32.92% of Java online submissions for Arranging Coins.
 * Memory Usage: 36.8 MB, less than 5.26% of Java online submissions for Arranging Coins.
 */
class Solution {
    public int arrangeCoins(int n) {
        int k = n;
        for (int i = 1; i <= k; i++) {
            if (n - i < 0) {
                return i - 1;
            } else if (n - i == 0) {
                return i;
            }
            n -= i;
        }
        return 0;
    }
}