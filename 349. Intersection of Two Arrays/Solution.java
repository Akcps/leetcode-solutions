/**
 * Runtime: 4 ms, faster than 21.96% of Java online submissions for Intersection of Two Arrays.
 * Memory Usage: 41.4 MB, less than 6.75% of Java online submissions for Intersection of Two Arrays.
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums2) {
            set2.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int num: set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}