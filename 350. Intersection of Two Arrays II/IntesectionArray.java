/**
 * Runtime: 4 ms, faster than 31.24% of Java online submissions for Intersection of Two Arrays II.
 * Memory Usage: 41.5 MB, less than 6.45% of Java online submissions for Intersection of Two Arrays II.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();

        for (int n: nums1) {
            nums1Map.put(n, nums1Map.getOrDefault(n, 0) + 1);
        }

        for (int n: nums2) {
            nums2Map.put(n, nums2Map.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key: nums2Map.keySet()) {
            if (nums1Map.containsKey(key)) {
                for (int i = 0; i < Math.min(nums1Map.get(key), nums2Map.get(key)); i++) {
                    result.add(key);
                }
            }
        }
        int [] res = new int[result.size()];
        int i = 0;
        for (int n: result) {
            res[i++] = n;
        }
        return res;
    }
}