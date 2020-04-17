/**
 * Runtime: 93 ms, faster than 67.25% of Java online submissions for Two Sum III - Data structure design.
 * Memory Usage: 47.5 MB, less than 45.00% of Java online submissions for Two Sum III - Data structure design.
 */
class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: map.keySet()) {
            int complement = value - key;
            if (key != complement) {
                if (map.containsKey(complement)) {
                    return true;
                }
            } else {
                if (map.get(complement) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */