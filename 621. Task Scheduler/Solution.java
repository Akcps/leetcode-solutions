/**
 * Runtime: 31 ms, faster than 32.09% of Java online submissions for Task Scheduler.
 * Memory Usage: 41.9 MB, less than 5.88% of Java online submissions for Task Scheduler.
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (char t: tasks)
            map.put(t, map.getOrDefault(t, 0) + 1);

        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int v = maxHeap.poll();
                    if (v > 1)
                        temp.add(v-1);
                }
                cycles++;
                if (maxHeap.isEmpty() && temp.size() == 0)
                    break;
            }
            for (int j : temp)
                maxHeap.add(j);
        }
        return cycles;
    }
}