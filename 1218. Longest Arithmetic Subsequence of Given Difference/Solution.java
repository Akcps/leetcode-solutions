/**
 * Runtime: 36 ms, faster than 92.02% of Java online submissions for Longest Arithmetic Subsequence of Given Difference.
 * Memory Usage: 56.5 MB, less than 100.00% of Java online submissions for Longest Arithmetic Subsequence of Given Difference.
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: arr)
            map.put(a, map.getOrDefault(a - difference, 0) + 1);

        int max = -1;
        for (int a: map.values())
            max = Math.max(a, max);
        return max;
    }
}