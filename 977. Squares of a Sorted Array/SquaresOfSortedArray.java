/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
 * Memory Usage: 42.2 MB, less than 70.12% of Java online submissions for Squares of a Sorted Array.
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int[] result = new int[A.length];
        int index = high;
        while (low <= high) {
            int lower = A[low] * A[low];
            int higher = A[high] * A[high];
            if (lower <= higher) {
                result[index] = higher;
                high--;
            } else {
                result[index] = lower;
                low++;
            }
            index--;
        }
        return result;
    }
}