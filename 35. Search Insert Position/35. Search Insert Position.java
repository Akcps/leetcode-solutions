/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
 * Memory Usage: 39.8 MB, less than 23.75% of Java online submissions for Search Insert Position.
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if (target < nums[low]) {
            return 0;
        }
        if (target > nums[high]) {
            return high + 1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}