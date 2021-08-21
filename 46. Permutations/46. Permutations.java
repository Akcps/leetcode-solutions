/**
 * Runtime: 2 ms, faster than 46.01% of Java online submissions for Permutations.
 * Memory Usage: 41.3 MB, less than 9.91% of Java online submissions for Permutations.
 */

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutations(nums, new ArrayList<Integer>(), used);
        return result;
    }

    private void generatePermutations(int[] nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                generatePermutations(nums, current, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}