class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        
        int index = -1;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - (leftSum + nums[i]))) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        
        return index;
    }
}