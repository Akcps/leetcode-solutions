/**
 * Runtime: 20 ms, faster than 76.94% of Java online submissions for Contiguous Array.
 * Memory Usage: 49.1 MB, less than 100.00% of Java online submissions for Contiguous Array.
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else  {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}