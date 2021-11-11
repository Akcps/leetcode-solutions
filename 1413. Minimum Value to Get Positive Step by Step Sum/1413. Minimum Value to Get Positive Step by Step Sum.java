/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
 * Memory Usage: 36.7 MB, less than 44.46% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
 */

class Solution {
    public int minStartValue(int[] nums) {
        int minVal = 0;
        int total = 0;

        for (int num : nums) {

            total += num;
            minVal = Math.min(minVal, total);
        }
        return -minVal + 1;
    }
}