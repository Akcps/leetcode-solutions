/**
 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
 * Memory Usage: 42.5 MB, less than 46.34% of Java online submissions for Range Sum Query - Immutable.
 */
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if (nums.length > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        int low = 0;
        if (i - 1 >= 0) {
            low = sum[i - 1];
        }
        int high = sum[j];
        return high - low;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */