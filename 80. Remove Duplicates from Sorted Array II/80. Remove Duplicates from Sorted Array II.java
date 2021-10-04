/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
 * Memory Usage: 41.5 MB, less than 21.39% of Java online submissions for Remove Duplicates from Sorted Array II.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int k = 1;
        int currentVal = nums[0];
        while (j < nums.length) {
            if (nums[j] == currentVal) {
                k++;
            } else {
                currentVal = nums[j];
                k = 1;
            }
            if (k <= 2) {
                nums[i++] = currentVal;
            }
            j++;
        }
        return i;
    }
}