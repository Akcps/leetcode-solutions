/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Patching Array.
 * Memory Usage: 38.7 MB, less than 36.48% of Java online submissions for Patching Array.
 */

class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long reach = 0;
        int i = 0;
        while (reach < n) {
            if (i >= nums.length) {
                reach += reach + 1; // next number after reach is the number to pe patched
                count++;
            } else if (i < nums.length && nums[i] <= (reach + 1)) { // use the next element, nothing to patch
                reach += nums[i];
                i++;
            } else {
                reach += reach + 1;
                count++;
            }
        }

        return count;
    }
}