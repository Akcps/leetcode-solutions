/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
 * Memory Usage: 41.4 MB, less than 6.00% of Java online submissions for Peak Index in a Mountain Array.
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 1;
        int result = 0;
        while (i < A.length) {
            if (A[i] > A[i-1]) {
                result = i;
            }
            i++;
        }
        return result;
    }
}