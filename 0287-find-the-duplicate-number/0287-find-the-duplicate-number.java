class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        
        for (int n: nums) {
            
            int cur = Math.abs(n);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
         for (int i = 0; i < nums.length; i++) {
              nums[i] = Math.abs(nums[i]);
         }
           
        return duplicate;
    }
}