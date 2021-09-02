/**
 * Runtime: 3 ms, faster than 43.88% of Java online submissions for Array Nesting.
 * Memory Usage: 46.6 MB, less than 7.01% of Java online submissions for Array Nesting.
 */

class Solution {
    int maxLen = Integer.MIN_VALUE;

    public int arrayNesting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            maxLen = Math.max(maxLen, calculateLength(nums, i));
        }
        return maxLen;
    }

    private int calculateLength(int[] nums, int position) {
        if (position >= nums.length || nums[position] < 0 || position < 0) {
            return 0;
        }
        int nextPosition = nums[position];
        nums[position] = Integer.MIN_VALUE;
        return 1 + calculateLength(nums, nextPosition);
    }
}