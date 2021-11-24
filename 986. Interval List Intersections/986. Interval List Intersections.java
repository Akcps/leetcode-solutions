/**
 * Runtime: 3 ms, faster than 83.30% of Java online submissions for Interval List Intersections.
 * Memory Usage: 42.4 MB, less than 86.49% of Java online submissions for Interval List Intersections.
 */
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> intervals = new ArrayList<>();

        int i = 0, j = 0;
        int[] intr = new int[2];
        while(i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if (low <= high) {
                intervals.add(new int[] { low, high });
            }
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        int[][] arr = new int[intervals.size()][2];
        int idx = 0;
        for (int[] interval : intervals) {
            arr[idx++] = interval;
        }
        return arr;

    }
}