/**
 * Runtime: 2 ms, faster than 99.65% of Java online submissions for Sort Array By Parity II.
 * Memory Usage: 39.7 MB, less than 97.11% of Java online submissions for Sort Array By Parity II.
 */
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        while (even < nums.length && odd < nums.length) {
            while (even < nums.length && nums[even] % 2 == 0) {
                even += 2;
            }
            while (odd < nums.length && nums[odd] % 2 == 1) {
                odd += 2;
            }
            if (even < nums.length && odd < nums.length) {
                swap(nums, even, odd);
                even += 2;
                odd += 2;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}