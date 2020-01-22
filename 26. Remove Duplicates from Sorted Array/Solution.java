/**
 * Runtime: 1 ms, faster than 89.62% of Java online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 48.4 MB, less than 5.32% of Java online submissions for Remove Duplicates from Sorted Array.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

}