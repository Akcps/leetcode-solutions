/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 40 MB, less than 5.59% of Java online submissions for Move Zeroes.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        for (int nonZero = 0, curr = 0;  curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                swap(nums, nonZero, curr);
                nonZero++;
            }
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}