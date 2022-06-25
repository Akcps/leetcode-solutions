class Solution {
    public int search(int[] nums, int target) {
        int res = binarySearch(nums, 0, nums.length - 1, target);
        return res;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target); 
        }
    }
}