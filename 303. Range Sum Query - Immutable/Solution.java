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


/**
 * Using Segment Trees - Sum Query Range
 *
 * Runtime: 9 ms, faster than 41.32% of Java online submissions for Range Sum Query - Immutable.
 * Memory Usage: 43.7 MB, less than 26.20% of Java online submissions for Range Sum Query - Immutable.
 */

class NumArray {

    int[] tree;
    int n;
    int len;

    public NumArray(int[] nums) {
        len = nums.length;
        n = nextPowerOf2(len);
        tree = new int[2 * n - 1];
        createSegmentTree(nums, 0, len - 1, 0);
    }

    public int sumRange(int left, int right) {
        return sumRangeQuery(left, right, 0, len - 1, 0);
    }

    private void createSegmentTree(int[] input, int low, int high, int pos) {

        if (low == high) {
            tree[pos] = input[low];
            return;
        }

        int mid = (low + high) / 2;

        createSegmentTree(input, low, mid, 2 * pos + 1);
        createSegmentTree(input, mid + 1, high, 2 * pos + 2);

        tree[pos] = tree[2 * pos + 1] + tree[2 * pos + 2];
    }

    private int sumRangeQuery(int left, int right, int low, int high, int pos) {

        if (left <= low && right >= high) {
            return tree[pos];
        }

        if (left > high || right < low) {
            return 0;
        }

        int mid = (low + high) / 2;

        return sumRangeQuery(left, right, low, mid, 2 * pos + 1) + sumRangeQuery(left, right, mid + 1, high, 2 * pos + 2);

    }

    private int nextPowerOf2(int n) {

        if (n == 0) {
            return 1;
        }

        if (n > 0 && (n & (n-1)) == 0) {
            return n;
        }

        int count = 0;
        while (n != 0) {
            n >>= 1;
            count++;
        }

        return 1 << count;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */