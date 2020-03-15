/**
 * Runtime: 14 ms, faster than 92.84% of Java online submissions for Largest Values From Labels.
 * Memory Usage: 43.1 MB, less than 100.00% of Java online submissions for Largest Values From Labels.
 */
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<ValueLabel> maxHeap = new PriorityQueue<ValueLabel>((a, b) -> b.value - a.value);
        for (int i = 0; i < values.length; i++) {
            maxHeap.add(new ValueLabel(values[i], labels[i]));
        }
        int largestValue = 0;
        Map<Integer, Integer> used = new HashMap<>();
        while (!maxHeap.isEmpty() && num_wanted > 0) {
            ValueLabel polled = maxHeap.poll();
            int val = polled.value;
            int lab = polled.label;
            if (!used.containsKey(lab) || used.get(lab) < use_limit) {
                largestValue += val;
                used.put(lab, used.getOrDefault(lab, 0) + 1);
                num_wanted--;
            }
        }
        return largestValue;
    }

    class ValueLabel {
        int value;
        int label;

        public ValueLabel(int v, int l) {
            this.value = v;
            this.label = l;
        }
    }
}