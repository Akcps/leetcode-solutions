/**
 * Runtime: 3 ms, faster than 43.65% of Java online submissions for Jump Game.
 * Memory Usage: 63.9 MB, less than 10.79% of Java online submissions for Jump Game.
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int curMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curMaxIndex >= nums.length - 1) {
                return true;
            }
            if (i > curMaxIndex) {
                return false;
            }
            curMaxIndex = Math.max(i + nums[i], curMaxIndex);
        }
        if (curMaxIndex >= nums.length - 1) {
            return true;
        }
        return false;
    }

}