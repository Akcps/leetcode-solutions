/**
 * Runtime: 30 ms, faster than 95.59% of Java online submissions for Maximum Size Subarray Sum Equals k.
 * Memory Usage: 68.4 MB, less than 84.60% of Java online submissions for Maximum Size Subarray Sum Equals k.
 */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (indexMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - indexMap.get(sum - k));
            }

            if (!indexMap.containsKey(sum)) {
                indexMap.put(sum, i);
            }
        }
        return maxLength;
    }
}