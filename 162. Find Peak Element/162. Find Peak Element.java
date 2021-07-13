/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
 * Memory Usage: 38.9 MB, less than 29.05% of Java online submissions for Find Peak Element.
 * Time Complexity: O (log n)
 * Space Complexity: O (1)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid + 1) < nums.length && nums[mid + 1] < nums[mid] && (mid - 1) >= 0 && nums[mid - 1] < nums[mid]) {
                return mid;
            }
            if ((mid + 1) < nums.length && nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
    }
}