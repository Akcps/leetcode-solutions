class Solution {
    public int jump(int[] nums) {
        int start = 0; 
        int end = 0;
        int count = 0;
        
        while (end < nums.length - 1) {
            
            int maxReach = 0;
            for (int i = start; i <= end; i++) {
                maxReach = Math.max(maxReach , i + nums[i]) ;
            }
            
            start = end + 1;
            end = maxReach;
            count++;
        }
        
        return count;
    }
}