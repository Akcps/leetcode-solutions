/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Element.
 * Memory Usage: 42.2 MB, less than 5.05% of Java online submissions for Remove Element.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}