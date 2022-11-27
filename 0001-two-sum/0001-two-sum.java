class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (indexMap.containsKey(remaining)) {
                return new int[] {indexMap.get(remaining), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}