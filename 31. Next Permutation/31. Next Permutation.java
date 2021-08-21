/**
 * Runtime: 1 ms, faster than 36.64% of Java online submissions for Next Permutation.
 * Memory Usage: 40.4 MB, less than 6.75% of Java online submissions for Next Permutation.
 * Time Complexity: O(N Log N)
 * Space Complexity: O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        while (j > 0 && nums[j - 1] >= nums[j]) {
            j--;
        }
        if (j == 0) {
            Arrays.sort(nums);
            return;
        }
        int val = nums[j - 1];
        int minVal = Integer.MAX_VALUE;
        int index = j - 1;
        int newIndex = 0;
        while (j < n) {
            if (nums[j] > val && nums[j] < minVal) {
                minVal = nums[j];
                newIndex = j;
            }
            j++;
        }

        int temp = nums[index];
        nums[index] = nums[newIndex];
        nums[newIndex] = temp;
        Arrays.sort(nums, index + 1, n);
    }
}
