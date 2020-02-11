/**
 * Runtime: 63 ms, faster than 21.74% of Java online submissions for Minimum Cost to Connect Sticks.
 * Memory Usage: 42.5 MB, less than 100.00% of Java online submissions for Minimum Cost to Connect Sticks.
 */
class Solution {

    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick: sticks)
            minHeap.add(stick);
        int sum = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            int c = a + b;
            sum += c;
            minHeap.add(c);
        }
        return sum;
    }
}