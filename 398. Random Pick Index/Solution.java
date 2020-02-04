/**
 * Runtime: 66 ms, faster than 50.11% of Java online submissions for Random Pick Index.
 * Memory Usage: 53.7 MB, less than 58.82% of Java online submissions for Random Pick Index.
 */
class Solution {
    Random rand = new Random();
    Map<Integer, List<Integer>> numMap = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = numMap.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            numMap.put(nums[i], indices);

        }
    }

    public int pick(int target) {
        List<Integer> list = numMap.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */