/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 42.9 MB, less than 99.29% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last  = -1;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid - 1 >= 0 && nums[mid - 1] != target || mid == 0 ) {
                    first = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid + 1 < nums.length && nums[mid + 1] != target || mid == nums.length - 1) {
                    last = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] {first, last};
    }


}