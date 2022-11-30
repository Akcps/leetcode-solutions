class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        
         if (nums[right] > nums[0]) {
            return nums[0];
        }

        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }
            
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return Integer.MAX_VALUE;
    }
}