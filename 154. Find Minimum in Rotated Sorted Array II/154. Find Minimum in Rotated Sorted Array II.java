class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return nums[0];
        } else {
            if (pivot == nums.length - 1) {
                return nums[0];
            } else {
                return nums[pivot + 1];
            }
        }
    }

    private int findPivot(int[] nums, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
            return mid;
        }
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return mid - 1;
        }
        int retVal = findPivot(nums, low, mid - 1);
        if (retVal != -1) {
            return retVal;
        } else {
            return findPivot(nums, mid + 1, high);
        }
    }
}