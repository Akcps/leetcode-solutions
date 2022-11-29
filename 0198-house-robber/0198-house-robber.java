class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        
        for (int i = 3; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        
        return Math.max (dp[nums.length - 1], dp[nums.length]);
    }
}