/**
 * Runtime: 93 ms, faster than 43.96% of Java online submissions for Range Sum Query - Mutable.
 * Memory Usage: 73 MB, less than 12.19% of Java online submissions for Range Sum Query - Mutable.
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

    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, len - 1, 0);
    }

    private void updateSegmentTree(int index, int val, int low, int high, int pos) {
        if (index > high ||  index < low) {
            return;
        }
        if (low == high) {
            tree[pos] = val;
            return;
        }
        int mid = (low + high) / 2;

        updateSegmentTree(index, val, low, mid, 2 * pos + 1);
        updateSegmentTree(index, val, mid + 1, high, 2 * pos + 2);

        tree[pos] = tree[2 * pos + 1] + tree[2 * pos + 2];

    }

    public int sumRange(int left, int right) {
        return sumRangeQuery(left, right, 0, len - 1, 0);

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
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */