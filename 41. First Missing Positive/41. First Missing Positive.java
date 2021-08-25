/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
 * Memory Usage: 35.2 MB, less than 100.00% of Java online submissions for First Missing Positive.
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctPosition = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctPosition]) {
                int j = correctPosition;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}