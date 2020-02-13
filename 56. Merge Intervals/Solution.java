/**
 * Runtime: 8 ms, faster than 33.39% of Java online submissions for Merge Intervals.
 * Memory Usage: 42.5 MB, less than 47.83% of Java online submissions for Merge Intervals.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval: intervals) {
            int[] last;
            if (result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]) {
                last = new int[2];
                last[0] = interval[0];
                last[1] = interval[1];
                result.add(last);
            } else {
                last = result.get(result.size() - 1);
                last[1]  = Math.max(interval[1], last[1]);
            }

        }

        return result.toArray(new int[result.size()][]);

    }

}