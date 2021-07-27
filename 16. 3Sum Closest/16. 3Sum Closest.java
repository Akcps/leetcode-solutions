/**
 * Runtime: 2 ms, faster than 99.85% of Java online submissions for 3Sum Closest.
 * Memory Usage: 42.8 MB, less than 6.67% of Java online submissions for 3Sum Closest.
 */
class Solution {
    int closestSum = 0;
    public int threeSumClosest(int[] nums, int target) {
        if (target < 0) {
            closestSum = Integer.MAX_VALUE + target;
        } else {
            closestSum = Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (closestSum == target) {
                return target;
            }
            findClosest(nums, i + 1, nums[i], target);
        }
        return closestSum;
    }

    private void findClosest(int[] nums, int start, int element, int target) {
        int end = nums.length - 1;
        while (start < end) {
            int sum = element + nums[start] + nums[end];
            if (Math.abs(sum - target) == 0) {
                closestSum = sum;
                return;
            }
            if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                closestSum = sum;
            }
            if (target > sum) {
                start++;
            } else {
                end--;
            }
        }
    }
}