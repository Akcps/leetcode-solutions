/**
 * Runtime: 25 ms, faster than 53.43% of Java online submissions for 4Sum.
 * Memory Usage: 48 MB, less than 14.49% of Java online submissions for 4Sum.
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            int findSum = target - nums[i];
            Set<List<Integer>> threeSums = threeSum(nums, findSum, i + 1);

            for (List<Integer> threeSum : threeSums) {
                List<Integer> sum4 = new ArrayList<>();
                sum4.add(nums[i]);
                sum4.addAll(threeSum);
                result.add(sum4);
            }

        }

        return new ArrayList<>(result);
    }

    private Set<List<Integer>> threeSum(int[] nums, int target, int start) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i = start; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
