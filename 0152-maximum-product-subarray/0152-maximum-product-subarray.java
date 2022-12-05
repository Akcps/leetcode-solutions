class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
            
        
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
      
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            
            max = tempMax;
            
            res = Math.max(max, res);
            
        }
        return res;
    }
}