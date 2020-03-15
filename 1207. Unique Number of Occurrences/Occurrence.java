/**
 * Runtime: 1 ms, faster than 99.79% of Java online submissions for Unique Number of Occurrences.
 * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Unique Number of Occurrences.
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int key: map.keySet()) {
            if (set.contains(map.get(key))) {
                return false;
            }
            set.add(map.get(key));
        }
        return true;
    }
}