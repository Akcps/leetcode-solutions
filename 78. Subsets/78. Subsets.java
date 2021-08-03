/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
 * Memory Usage: 37.3 MB, less than 99.18% of Java online submissions for Subsets.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        makeSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void makeSubsets(int[] nums, int ind, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = ind; i < nums.length; i++) {
            current.add(nums[i]);
            makeSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
        return;
    }
}