/**
 * Runtime: 5 ms, faster than 23.10% of Java online submissions for Single Number III.
 * Memory Usage: 40.5 MB, less than 42.61% of Java online submissions for Single Number III.
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res[index] = key;
                index++;
            }
        }
        return res;
    }
}