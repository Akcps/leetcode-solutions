/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
 * Memory Usage: 37.5 MB, less than 71.65% of Java online submissions for Sort Colors.
 */

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, k = 0;
        while (left <= right) {
            if (nums[left] == 0) {
                int temp = nums[left];
                nums[left] = nums[k];
                nums[k] = temp;
                left++;
                k++;
            } else if (nums[left] == 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
    }
}