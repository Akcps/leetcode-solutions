/**
 * Runtime: 3 ms, faster than 99.35% of Java online submissions for Max Consecutive Ones III.
 * Memory Usage: 48.6 MB, less than 7.14% of Java online submissions for Max Consecutive Ones III.
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
        }
        return right - left;
    }
}