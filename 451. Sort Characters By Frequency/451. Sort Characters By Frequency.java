class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Character c : frequency.keySet()) {
            maxHeap.add(new Pair<>(c, frequency.get(c)));
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int count = maxHeap.peek().getValue();
            char letter = maxHeap.peek().getKey();
            while (count > 0) {
                result.append(letter);
                count--;
            }
            maxHeap.poll();
        }
        return result.toString();
    }
}