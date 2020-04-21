/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    boolean oneFound = false;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);
        int leftmost = cols;
        for (int i = 0; i < rows; i++) {
            leftmost = binarySearch(0, leftmost - 1, binaryMatrix, i);
        }
        if (!oneFound) {
            return -1;
        }
        return leftmost;
    }
    private int binarySearch(int low, int high, BinaryMatrix binaryMatrix, int row) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (binaryMatrix.get(row, mid) == 1) {
                oneFound = true;
                if (mid - 1 >= 0 && binaryMatrix.get(row, mid - 1) == 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}