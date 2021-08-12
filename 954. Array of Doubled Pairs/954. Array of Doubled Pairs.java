/**
 * Runtime: 35 ms, faster than 64.34% of Java online submissions for Array of Doubled Pairs.
 * Memory Usage: 47 MB, less than 45.30% of Java online submissions for Array of Doubled Pairs.
 * Time Complexity: O (N log N)
 * Space Complexity: O (N)
 */

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 0) {
                continue;
            }
            int target = key < 0 ? key / 2: key * 2;

            if (key < 0 && key % 2 != 0) {
                return false;
            }
            if (map.get(key) > map.getOrDefault(target, 0)) {
                return false;
            }
            map.put(target, map.get(target) - map.get(key));
        }
        return true;
    }
}