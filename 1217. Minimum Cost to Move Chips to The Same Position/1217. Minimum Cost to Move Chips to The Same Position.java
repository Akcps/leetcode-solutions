/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
 * Memory Usage: 36.7 MB, less than 55.73% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
 */

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int p : position) {
            if (p % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}