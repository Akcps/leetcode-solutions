class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        count.entrySet().iterator().forEachRemaining(entry -> {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        });
        
        int i = 0;
        while(k-- > 0) {
            result[i++] = heap.poll().getKey();
        }
        return result;
    }
}