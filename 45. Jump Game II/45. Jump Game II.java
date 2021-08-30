/**
 * Runtime: 1 ms, faster than 99.36% of Java online submissions for Jump Game II.
 * Memory Usage: 46.2 MB, less than 12.69% of Java online submissions for Jump Game II.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int maxIndex = nums[0];
        int minCount = 1;

        int i = 1;

        while (i < nums.length - 1) {
            if (maxIndex >= nums.length - 1) {
                return minCount;
            }
            int tempMaxIndex = maxIndex;

            while (i < nums.length && i <= maxIndex) {
                tempMaxIndex = Math.max(tempMaxIndex, i + nums[i]);
                i++;
            }
            maxIndex = tempMaxIndex;
            minCount++;
        }

        return minCount;
    }
}