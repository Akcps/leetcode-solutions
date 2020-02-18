/**
 * Runtime: 2 ms, faster than 31.08% of Java online submissions for Missing Element in Sorted Array.
 * Memory Usage: 48.4 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
 **/
class Solution {
    public int missingElement(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                int diff = nums[i] - nums[i - 1];
                if (diff > k) {
                    return nums[i - 1] + k;
                } else {
                    k -= diff - 1;
                }
            }
        }
        return nums[nums.length - 1] + k;
    }

}

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Element in Sorted Array.
 * Memory Usage: 48.6 MB, less than 100.00% of Java online submissions for Missing Element in Sorted Array.
 */
class Solution {

    private int missing(int index, int[] nums) {
        return nums[index] - nums[0] - index;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        if (k > missing(n - 1, nums)) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }

        int low = 0;
        int high = n - 1;

        while (low != high) {
            int pivot = low + (high - low) / 2;

            if (missing(pivot, nums) < k) {
                low = pivot + 1;
            }
            else {
                high = pivot;
            }
        }
        return nums[low - 1] + k - missing(low - 1, nums);
    }

}
