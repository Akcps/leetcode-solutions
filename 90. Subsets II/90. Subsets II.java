/**
 * Runtime: 1 ms, faster than 99.62% of Java online submissions for Subsets II.
 * Memory Usage: 39 MB, less than 84.13% of Java online submissions for Subsets II.
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return new ArrayList(result);
        Arrays.sort(nums);
        makeSubsets(nums, 0, new ArrayList<>(), result);
        return new ArrayList(result);
    }


    private void makeSubsets(int[] nums, int ind, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            makeSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
        return;
    }
}