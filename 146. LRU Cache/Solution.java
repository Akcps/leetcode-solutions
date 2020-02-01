/**
 * Runtime: 14 ms, faster than 88.12% of Java online submissions for LRU Cache.
 * Memory Usage: 53.3 MB, less than 83.44% of Java online submissions for LRU Cache.
 */
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer,Integer>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            // System.out.println(key);
            Iterator<Integer> it = map.keySet().iterator();
            it.next();
            it.remove();

        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */