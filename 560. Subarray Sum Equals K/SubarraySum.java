/**
 * Runtime: 11 ms, faster than 98.11% of Java online submissions for Subarray Sum Equals K.
 * Memory Usage: 42.2 MB, less than 5.43% of Java online submissions for Subarray Sum Equals K.
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap <>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int runningSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            runningSum += num;
            // Starting from the beigining.
            if (runningSum == k) {
                count++;
            }
            // Subarray
            count += countMap.getOrDefault(runningSum - k, 0);
            countMap.put(runningSum, countMap.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}