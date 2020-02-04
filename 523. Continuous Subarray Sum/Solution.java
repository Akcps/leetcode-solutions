/**
 * Runtime: 2 ms, faster than 99.73% of Java online submissions for Continuous Subarray Sum.
 * Memory Usage: 41.5 MB, less than 5.88% of Java online submissions for Continuous Subarray Sum
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int sum = 0;
        numMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (numMap.containsKey(sum)) {
                if (i - numMap.get(sum) > 1) {
                    return true;
                }
            } else {
                numMap.put(sum, i);
            }
        }
        return false;
    }
}