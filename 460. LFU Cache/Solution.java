/**
 * Runtime: 25 ms, faster than 83.94% of Java online submissions for LFU Cache.
 * Memory Usage: 54.1 MB, less than 85.00% of Java online submissions for LFU Cache.
 */
class LFUCache {

    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, HashSet<Integer>> freqSetMap;
    private int minFreq;
    private int capacity;
    public LFUCache(int c) {
        valueMap = new HashMap<Integer, Integer>();
        freqMap = new HashMap<Integer, Integer>();
        freqSetMap = new HashMap<Integer, HashSet<Integer>>();
        freqSetMap.put(1, new LinkedHashSet<Integer>());
        minFreq = 0;
        capacity = c;
    }

    public int get(int key) {
        if (capacity == 0)
            return -1;
        if (valueMap.containsKey(key)) {
            int value = valueMap.get(key);
            int freq = freqMap.get(key);
            freqSetMap.get(freq).remove(key);
            HashSet<Integer> freqSet = freqSetMap.getOrDefault(freq + 1, new LinkedHashSet<Integer>());
            freqSet.add(key);
            freqSetMap.put(freq + 1, freqSet);
            freqMap.put(key, freq + 1);
            if (minFreq == freq && freqSetMap.get(freq).size() == 0)
                minFreq++;
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            get(key);
            return;
        }
        if (valueMap.keySet().size() == capacity) {
            int removeKey = -1;
            for (Integer k: freqSetMap.get(minFreq)) {
                removeKey = k;
                break;
            }
            freqSetMap.get(minFreq).remove(removeKey);
            freqMap.remove(removeKey);
            valueMap.remove(removeKey);
        }
        valueMap.put(key, value);
        freqMap.put(key, 1);
        HashSet<Integer> freqSet = freqSetMap.get(1);
        freqSet.add(key);
        minFreq = 1;
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */