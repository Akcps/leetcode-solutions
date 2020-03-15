/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 37.8 MB, less than 47.17% of Java online submissions for Search in Rotated Sorted Array.
 */
class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1)
            return binarySearch(nums, 0, nums.length - 1, target);
        if (nums[pivot] == target)
            return pivot;
        if (target >= nums[0])
            return binarySearch(nums, 0, pivot, target);
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int low, int high, int key) {
        if (low > high)
            return -1;
        int mid = (low+high) / 2;
        if (nums[mid] == key)
            return mid;
        if (nums[mid] > key)
            return binarySearch(nums, low, mid - 1, key);
        return binarySearch(nums, mid + 1, high, key);
    }

    private int findPivot(int[] nums, int low, int high) {
        if (low > high)
            return -1;
        if (low == high)
            return low;
        int mid = (low + high) / 2;
        if (mid < high && nums[mid] > nums[mid + 1])
            return mid;
        if (mid >low && nums[mid - 1] > nums[mid])
            return mid-1;
        if (nums[low] >= nums[mid])
            return findPivot(nums, low, mid - 1);
        return findPivot(nums, mid + 1, high);
    }
}