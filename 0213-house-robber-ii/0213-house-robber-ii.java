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
        
        int max1 = robSimple(nums, 0, nums.length - 2);
        int max2 = robSimple(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
        
        public int robSimple(int[] nums, int start, int end) {
            int t1 = 0;
            int t2 = 0;

            for (int i = start; i <= end; i++) {
                int temp = t1;
                t1 = Math.max(nums[i] + t2, t1);
                t2 = temp;
            }

            return t1;
        }
}