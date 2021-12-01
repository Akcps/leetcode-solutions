/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
 * Memory Usage: 36 MB, less than 99.43% of Java online submissions for House Robber.
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = max;
        }
        return Math.max(prev, prevPrev);
    }
}