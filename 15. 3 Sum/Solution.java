/**
 * Runtime: 27 ms, faster than 94.01% of Java online submissions for 3Sum.
 * Memory Usage: 49 MB, less than 53.71% of Java online submissions for 3Sum.
 */
class Solution {
    private void twoSum(int[] arr, int left, int targetSum, List<List<Integer>> threeSums) {
        int right = arr.length - 1;

        while (left<right) {

            int targetDiff = targetSum - arr[left];

            if (targetDiff == arr[right]) { // found the triplet
                threeSums.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets

            } else if (targetDiff > arr[right])
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSums = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum(nums, i+1, -nums[i], threeSums);
        }
        return threeSums;
    }
}