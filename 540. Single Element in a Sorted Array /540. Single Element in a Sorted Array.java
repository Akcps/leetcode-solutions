/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
 * Memory Usage: 42.4 MB, less than 12.90% of Java online submissions for Single Element in a Sorted Array.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}