/**
 * Runtime: 15 ms, faster than 77.75% of Java online submissions for Kth Smallest Number in Multiplication Table.
 * Memory Usage: 35.9 MB, less than 44.23% of Java online submissions for Kth Smallest Number in Multiplication Table.
 */

class Solution {
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
}