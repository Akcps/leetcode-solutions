/**
 * Runtime: 314 ms, faster than 73.43% of Java online submissions for Longest Arithmetic Sequence.
 * Memory Usage: 144.4 MB, less than 66.67% of Java online submissions for Longest Arithmetic Sequence.
 */
class Solution {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer> dp[] = new HashMap[A.length];
        int maxCount = Integer.MIN_VALUE;
        dp[0] = new HashMap<>();

        for (int i = 1; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int count = dp[j].getOrDefault(diff, 0) + 1;
                maxCount = Math.max(count, maxCount);
                dp[i].put(diff, count);
            }
        }
        return maxCount + 1;
    }
}