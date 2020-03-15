/**
 * Runtime: 7 ms, faster than 55.68% of Java online submissions for Meeting Rooms II.
 * Memory Usage: 42.5 MB, less than 5.12% of Java online submissions for Meeting Rooms II.
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek())  {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}