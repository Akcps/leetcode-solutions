/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones.
 * Memory Usage: 40.4 MB, less than 53.00% of Java online submissions for Max Consecutive Ones.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount += 1;
            } else {
                maxCount = Math.max(currentCount, maxCount);
                currentCount = 0;
            }
        }
        maxCount = Math.max(currentCount, maxCount);
        return maxCount;
    }
}