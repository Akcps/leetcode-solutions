class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int endTime = 0;
        for (int[] s : intervals) {
            if (s[0] < endTime) {
                return false;
            }
            endTime = s[1];
        }
        return true;
    }
}