class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        if (target <= nums[low]) {
            return 0;
        }
        
        if (target == nums[high]) {
            return high;
        }
        
        if (target > nums[high]) {
            return high + 1;
        }
        
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (mid - 1 >= 0 && target > nums[mid - 1] && target < nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
}