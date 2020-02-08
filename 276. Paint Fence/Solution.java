/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Paint Fence.
 * Memory Usage: 36.4 MB, less than 11.11% of Java online submissions for Paint Fence.
 */
class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0){
            return 0;
        }
        int same = 0;
        int diff = k;
        for(int i = 2; i <= n; i++) {
            int previousDiff = diff;
            diff = (same + diff) * (k - 1);
            same = previousDiff;
        }
        return same + diff;
    }
}