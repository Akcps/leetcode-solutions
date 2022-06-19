class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numToFind = target - nums[i];
            if (map.containsKey(numToFind)) {
                return new int[] {map.get(numToFind), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}