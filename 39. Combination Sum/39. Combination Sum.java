/**
 * Runtime: 3 ms, faster than 75.95% of Java online submissions for Combination Sum.
 * Memory Usage: 39.4 MB, less than 39.94% of Java online submissions for Combination Sum.
 */

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        combinations(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }


    private void combinations(int[] candidates, int target, int start, List<Integer> current, int currentSum) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinations(candidates, target, i, current, currentSum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}