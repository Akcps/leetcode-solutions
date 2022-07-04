class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for (int s: stones) {
            maxHeap.add(s);
        }
        
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y > x) {
                int diff = y - x;
                maxHeap.add(diff);
            }
        }
        return maxHeap.size() == 0 ? 0: maxHeap.poll();
    }
}