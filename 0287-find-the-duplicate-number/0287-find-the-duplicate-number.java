class Solution {
    public int findDuplicateUsingNegative(int[] nums) {
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
    
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
    
}