class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<Meeting> heap = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (int[] interval: intervals){
            heap.add(new Meeting(interval[0], interval[1]));
        }
        
        int endTime = -1;
        while (!heap.isEmpty()) {
            Meeting m = heap.poll();
            if (m.start < endTime) {
                return false;
            }
            endTime = m.end;
        }
        return true;
    }
    
    class Meeting {
        int start;
        int end;
        
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}