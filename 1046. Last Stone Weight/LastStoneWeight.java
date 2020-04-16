/**
 * Runtime: 1 ms, faster than 87.02% of Java online submissions for Last Stone Weight.
 * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Last Stone Weight.
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int stone: stones) {
            maxHeap.add(stone);
        }
        while (!maxHeap.isEmpty()) {
            int a = maxHeap.poll();
            if (maxHeap.isEmpty()) {
                return a;
            }
            int b = maxHeap.poll();
            if (a != b) {
                maxHeap.add(a - b);
            }
        }
        return 0;
    }
}