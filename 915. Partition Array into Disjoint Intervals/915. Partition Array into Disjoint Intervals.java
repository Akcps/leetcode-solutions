/**
 * Runtime: 2 ms, faster than 66.54% of Java online submissions for Partition Array into Disjoint Intervals.
 * Memory Usage: 44.2 MB, less than 44.25% of Java online submissions for Partition Array into Disjoint Intervals.
 * Space Complexity: O(n)
 * Time Complexity: O(n)
 */

class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxLeft[i] = max;
            min = Math.min(min, nums[n - 1 - i]);
            minRight[n - 1 - i] = min;
        }

        for (int i = 1 ; i < n; i++) {
            if (maxLeft[i-1] <= minRight[i]) {
                return i;
            }
        }

        return -1;
    }
}