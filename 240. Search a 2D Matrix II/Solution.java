/**
 * Runtime: 5 ms, faster than 99.63% of Java online submissions for Search a 2D Matrix II.
 * Memory Usage: 42.2 MB, less than 100.00% of Java online submissions for Search a 2D Matrix II.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            }
            else if (matrix[row][col] < target)  {
                col++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}